package com.example.badminton2021be.badminton_backend_2021.dto;

import java.util.Date;

public class SchedulePractiseDto {

    private Long id;

    private Date dateTime;

    private Long addedAdminId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getAddedAdminId() {
        return addedAdminId;
    }

    public void setAddedAdminId(Long addedAdminId) {
        this.addedAdminId = addedAdminId;
    }
}
