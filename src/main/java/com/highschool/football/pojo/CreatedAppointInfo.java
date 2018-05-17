package com.highschool.football.pojo;

import com.highschool.football.entity.Appoint;
import com.highschool.football.entity.User;

import java.util.List;

public class CreatedAppointInfo {
    private Appoint appoint;
    private List<User> users;

    public CreatedAppointInfo() {
    }

    public CreatedAppointInfo(Appoint appoint, List<User> users) {
        this.appoint = appoint;
        this.users = users;
    }

    public Appoint getAppoint() {
        return appoint;
    }

    public void setAppoint(Appoint appoint) {
        this.appoint = appoint;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
