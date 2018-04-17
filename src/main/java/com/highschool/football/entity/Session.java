package com.highschool.football.entity;

import com.highschool.football.utils.DateUtil;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
public class Session {
    @Id
    @GeneratedValue
    private Integer id;
    private String sessionId;
    private String sessionValue;
    private Date lastDate;

    public Session(String sessionId, String sessionValue) {
        this.sessionId = sessionId;
        this.sessionValue = sessionValue;
        this.lastDate = DateUtil.dateAddHours(new Date(),1);
    }

    public Session() {
    }

    public Session(String sessionId, String sessionValue, Date lastDate) {
        this.sessionId = sessionId;
        this.sessionValue = sessionValue;
        this.lastDate = lastDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionValue() {
        return sessionValue;
    }

    public void setSessionValue(String sessionValue) {
        this.sessionValue = sessionValue;
    }
}
