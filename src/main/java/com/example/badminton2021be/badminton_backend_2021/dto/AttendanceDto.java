package com.example.badminton2021be.badminton_backend_2021.dto;

import java.util.Date;
import java.util.List;

public class AttendanceDto {

    private Long id;

    private Long addedAdminRegId;

    private Date date;

    private Long[] attendantPlayerIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddedAdminRegId() {
        return addedAdminRegId;
    }

    public void setAddedAdminRegId(Long addedAdminRegId) {
        this.addedAdminRegId = addedAdminRegId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long[] getAttendantPlayerIds() {
        return attendantPlayerIds;
    }

    public void setAttendantPlayerIds(Long[] attendantPlayerIds) {
        this.attendantPlayerIds = attendantPlayerIds;
    }
}

