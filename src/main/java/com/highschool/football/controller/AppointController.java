package com.highschool.football.controller;

import com.highschool.football.dao.*;
import com.highschool.football.entity.*;
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
    private List<Appoint> appointList(){
        return appointRepository.findAll();
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

}
