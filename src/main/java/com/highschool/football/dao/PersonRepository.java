package com.highschool.football.dao;

import com.highschool.football.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/*
* author: Harrison
* Time: 2018/4/10 14:54
* */
public interface PersonRepository extends JpaRepository<Person,Integer>{
//    //原生SQL实现更新方法接口
//    @Query(value = "update person set name=?1 where id=?2 ", nativeQuery = true)
//    @Modifying
//    public void update(String name,int id);
}
