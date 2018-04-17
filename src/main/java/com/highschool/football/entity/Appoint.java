package com.highschool.football.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
public class Appoint {
    @Id
    @GeneratedValue
    private Integer id;
    private Date createTime;
    private Date appointTime;
    private Integer siteId;
    private Integer creatorId;
    // 0 created
    // 1 acting
    // 2 finished
    // 3 canceled
    private Integer status;
    private Integer limitCount;
    private Double perCost;
    private Boolean creatorJoin;
    private Integer allCount;
    private Integer hasCount;


    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getHasCount() {
        return hasCount;
    }

    public void setHasCount(Integer hasCount) {
        this.hasCount = hasCount;
    }

    public Boolean getCreatorJoin() {
        return creatorJoin;
    }

    public void setCreatorJoin(Boolean creatorJoin) {
        this.creatorJoin = creatorJoin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(Integer limitCount) {
        this.limitCount = limitCount;
    }

    public Double getPerCost() {
        return perCost;
    }

    public void setPerCost(Double perCost) {
        this.perCost = perCost;
    }
}
