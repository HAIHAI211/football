package com.highschool.football.controller;

import com.highschool.football.dao.*;
import com.highschool.football.entity.*;
import com.highschool.football.pojo.AppointInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appoint")
public class AppointController {
    @Autowired
    AppointRepository appointRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AppointJoinUserRepository appointJoinUserRepository;
    /*
    * 查询全部约球订单
    * */
    @GetMapping(value="/find")
    private List<AppointInfo> appointList(@RequestParam("sessionId") String sessionId){


        Optional<Session> sessionOptional = sessionRepository.findFirstBySessionIdAndLastDateAfter(sessionId, new Date());
        if (sessionOptional.isPresent()){
            Session session = sessionOptional.get();
            String openId = session.getSessionValue();
            Optional<User> userOptional = userRepository.findByOpenId(openId);
            if (userOptional.isPresent()){
                User user = userOptional.get();
                List<AppointInfo> appointInfoList = appointRepository.findAppointInfo1(); // 所有的约球列表
                List<AppointJoinUser> appointJoinUserList = appointJoinUserRepository.findAllByUserId(user.getId()); // 用户参与的约球项目
                for (int i = 0; i < appointInfoList.size(); i++) {
                    AppointInfo appointInfo = appointInfoList.get(i);
                    for (int j = 0; j < appointJoinUserList.size(); j++) {
                        AppointJoinUser appointJoinUser = appointJoinUserList.get(j);
                        appointInfo.setHasJoin(appointInfo.getAppoint().getId() == appointJoinUser.getAppointId());
                    }
                }
                return appointInfoList;
            }
        }
        return null;
    }

    /*
    * 新建约球订单
    * */
    @PostMapping(value = "/add")
    private void addAppoint(@RequestParam("appointTime") Long appointTime, @RequestParam("siteId") Integer siteId,
                            @RequestParam("sessionId") String sessionId, @RequestParam("perCost") Double perCost,
                            @RequestParam("allCount") Integer allCount) {

        Optional<Session> sessionOptional = sessionRepository.findFirstBySessionIdAndLastDateAfter(sessionId, new Date());
        if (sessionOptional.isPresent()){
            Session session = sessionOptional.get();
            String openId = session.getSessionValue();
            Optional<User> userOptional = userRepository.findByOpenId(openId);
            if (userOptional.isPresent()){
                User user = userOptional.get();
                Integer creatorId = user.getId();
                Appoint appoint = new Appoint();

                appoint.setStatus(0); // 表示人员还未集齐
                appoint.setCreatorId(creatorId);
                appoint.setCreateTime(new Date());
                appoint.setAppointTime(new Date(appointTime));
                appoint.setPerCost(perCost);
                appoint.setAllCount(allCount);
                appoint.setHasCount(0);
                appoint.setSiteId(siteId);
                appointRepository.save(appoint);

            }
        }
    }

    /*
     * 加入约球订单
     * */
    @PostMapping(value = "/join")
    private CommonReponse joinAppoint(@RequestParam("sessionId") String sessionId, @RequestParam("appointId") Integer appointId) {

        Optional<Session> sessionOptional = sessionRepository.findFirstBySessionIdAndLastDateAfter(sessionId, new Date());
        if (sessionOptional.isPresent()){
            Session session = sessionOptional.get();
            String openId = session.getSessionValue();
            Optional<User> userOptional = userRepository.findByOpenId(openId);
            if (userOptional.isPresent()){
                User user = userOptional.get();
                Optional<Appoint> appointOptional = appointRepository.findById(appointId);
                if (appointOptional.isPresent()) {
                    Appoint appoint = appointOptional.get();
                    //检查是否已经参与过该约球
                    Optional<AppointJoinUser> appointJoinUserOptional = appointJoinUserRepository.findFirstByAppointIdAndUserId(appoint.getId(), user.getId());
                    if (appointJoinUserOptional.isPresent()) { // 重复加入
                        return new CommonReponse(CommonReponse.DUPLICATE_APPOINT_CODE, CommonReponse.DUPLICATE_APPOINT_MSG, null);
                    } else {
                        if (appoint.getHasCount() + 1 > appoint.getAllCount()) {
                            return new CommonReponse(CommonReponse.ACCOUNT_FILL_CODE, CommonReponse.ACCOUNT_FILL_MSG, null);
                        } else {
                            AppointJoinUser appointJoinUser = new AppointJoinUser();
                            appointJoinUser.setAppointId(appointId);
                            appointJoinUser.setUserId(user.getId());
                            appointJoinUserRepository.save(appointJoinUser);
                            appoint.setHasCount(appoint.getHasCount() + 1);
                            appointRepository.save(appoint);
                            return new CommonReponse(CommonReponse.SUCCESS_CODE, CommonReponse.SUCCESS_MSG, null);
                        }
                    }

                } else {
                    return new CommonReponse(CommonReponse.FAIL_CODE, CommonReponse.FAIL_MSG, null);
                }
            } else {
                return new CommonReponse(CommonReponse.LOGIN_FAIL_CODE, CommonReponse.LOGIN_FAIL_MSG, null);
            }
        } else {
            return new CommonReponse(CommonReponse.LOGIN_FAIL_CODE, CommonReponse.LOGIN_FAIL_MSG, null);
        }
    }


}
