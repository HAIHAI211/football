package com.highschool.football.dao;

import com.highschool.football.entity.Site;
import com.highschool.football.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* author: Harrison
* Time: 2018/4/12 16:10
* */
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByOpenId(String openId);
}
