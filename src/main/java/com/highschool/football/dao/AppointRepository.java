package com.highschool.football.dao;

import com.highschool.football.entity.Appoint;
import com.highschool.football.entity.Site;
import com.highschool.football.pojo.AppointInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
* author: Harrison
* Time: 2018/4/23 17:16
* */
public interface AppointRepository extends JpaRepository<Appoint,Integer>{
    @Query(value="SELECT new com.highschool.football.pojo.AppointInfo(a,u) FROM "
            + " Appoint a, com.highschool.football.entity.User u WHERE a.creatorId = u.id ")
    List<AppointInfo> findAppointInfo();
}
