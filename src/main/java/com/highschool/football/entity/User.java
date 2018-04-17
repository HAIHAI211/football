package com.highschool.football.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    //类型待定
    private String openId;
    private String avatar;
    private String name;
    private String phone;
    private Integer truthPoint;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTruthPoint() {
        return truthPoint;
    }

    public void setTruthPoint(Integer truthPoint) {
        this.truthPoint = truthPoint;
    }
}
