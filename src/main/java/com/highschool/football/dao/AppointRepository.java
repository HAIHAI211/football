package com.highschool.football.dao;

import com.highschool.football.entity.Appoint;
import com.highschool.football.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

/*
* author: Harrison
* Time: 2018/4/23 17:16
* */
public interface AppointRepository extends JpaRepository<Appoint,Integer>{
}
