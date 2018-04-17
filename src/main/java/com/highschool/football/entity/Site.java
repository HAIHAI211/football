package com.highschool.football.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
public class Site {
    @Id
    @GeneratedValue
    private Integer id;
    private Double longitude;
    private Double latitude;
    private String title;
    private String address;
    private Integer siteType;
    private Integer turfType;
    private Integer siteQuality;
    private String openTime;
    private String cost;
    private Boolean hasLight;
    private String pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSiteType() {
        return siteType;
    }

    public void setSiteType(Integer siteType) {
        this.siteType = siteType;
    }

    public Integer getTurfType() {
        return turfType;
    }

    public void setTurfType(Integer turfType) {
        this.turfType = turfType;
    }

    public Integer getSiteQuality() {
        return siteQuality;
    }

    public void setSiteQuality(Integer siteQuality) {
        this.siteQuality = siteQuality;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Boolean getHasLight() {
        return hasLight;
    }

    public void setHasLight(Boolean hasLight) {
        this.hasLight = hasLight;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
