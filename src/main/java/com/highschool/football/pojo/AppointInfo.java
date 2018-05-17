package com.highschool.football.pojo;

import com.highschool.football.entity.Appoint;
import com.highschool.football.entity.User;

public class AppointInfo {
    private User creator;
    private Appoint appoint;

    // private Boolean hasJoin;

    public AppointInfo(Appoint appoint, User user) {
        this.appoint = appoint;
        this.creator = user;
    }

    public AppointInfo() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Appoint getAppoint() {
        return appoint;
    }

    public void setAppoint(Appoint appoint) {
        this.appoint = appoint;
    }

//    public Boolean getHasJoin() {
//        return hasJoin;
//    }
//
//    public void setHasJoin(Boolean hasJoin) {
//        this.hasJoin = hasJoin;
//    }
}
