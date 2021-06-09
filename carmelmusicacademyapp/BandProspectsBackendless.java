package com.example.carmelmusicacademyapp;

import java.util.Date;

public class BandProspectsBackendless {

    private String name;
    private String age;
    private String teacher;
    private String instrument;
    private String lessonDays;
    private Date created;
    private Date updated;
    private String objectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getLessonDays() {
        return lessonDays;
    }

    public void setLessonDays(String lessonDays) {
        this.lessonDays = lessonDays;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
