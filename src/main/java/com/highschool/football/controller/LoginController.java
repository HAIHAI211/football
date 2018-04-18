package com.highschool.football.controller;

import com.highschool.football.api.API;
import com.highschool.football.dao.SessionRepository;
import com.highschool.football.dao.UserRepository;
import com.highschool.football.entity.CommonReponse;
import com.highschool.football.entity.Session;
import com.highschool.football.entity.User;
import com.highschool.football.utils.DateUtil;
import com.highschool.football.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import com.highschool.football.exception.SessionOutOfDateException;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;

    /*
    * 登录 code
    * */
    @GetMapping(value="/c/{code}")
    private CommonReponse<String> loginWithCode(@PathVariable String code, @RequestParam("avatar") String avatar, @RequestParam("nickName") String nickName){
        //根据code拿到openid
        String openId = API.getOpenId(code);
        System.out.println("openId是"+openId);
        String sessionId = StringUtil.GetGUID();


        //根据openid查询user是否存在,最终保存user到数据库中
        User user = new User();
        user.setOpenId(openId);
        Example<User> example = Example.of(user);
        Optional<User> optional =userRepository.findOne(example);
        if (optional.isPresent()){
            user = optional.get();
        }
        user.setAvatar(avatar);
        user.setName(nickName);
        userRepository.save(user);

        //创建session并返回给客户端
        System.out.println("sessionId是"+sessionId);
        Session session = new Session(sessionId, openId);
        sessionRepository.save(session);
        return new CommonReponse(CommonReponse.SUCCESS_CODE, CommonReponse.SUCCESS_MSG, sessionId);
    }

    /*
    * 登录 session
    * */
    @GetMapping(value="/s/{sessionId}")
    private CommonReponse<String> loginWithSession(@PathVariable String sessionId){
        //根据sessionId查询session是否存在且未过期
        Date now = new Date();
        Date lastDate = DateUtil.dateAddHours(now, 1);
        Optional<Session> sessionOptional = sessionRepository.findFirstBySessionIdAndLastDateAfter(sessionId, now);
        if (sessionOptional.isPresent()) { // 如果存在
            Session session = sessionOptional.get();
            session.setLastDate(lastDate);
            return new CommonReponse(CommonReponse.SUCCESS_CODE, CommonReponse.SUCCESS_MSG, sessionId);
        } else { // 如果不存在
            return new CommonReponse(CommonReponse.LOGIN_FAIL_CODE, CommonReponse.LOGIN_FAIL_MSG, sessionId);
        }
    }
}
