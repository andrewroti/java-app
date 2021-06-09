package com.example.carmelmusicacademyapp;

import java.util.Date;

public class LadderList {


    private String name;
    private String awardMonth;
    private String awardLevel;
    private String userEmail;
    private Date created;
    private Date updated;
    private String objectId;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAwardMonth() {
        return awardMonth;
    }

    public void setAwardMonth(String awardMonth) {
        this.awardMonth = awardMonth;
    }

    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdate() {
        return updated;
    }

    public void setUpdate(Date update) {
        this.updated = update;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

}
