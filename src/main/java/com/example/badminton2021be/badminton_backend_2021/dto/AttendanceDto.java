package com.example.badminton2021be.badminton_backend_2021.dto;

import java.util.Date;
import java.util.List;

public class AttendanceDto {

    private Long id;

    private Long addedAdminRegId;

    private Date date;

    private Long[] attendantPlayerIds;

    private Long attendanceForThisMonth;

    private Long attendanceAllMonthCount;

    private Long practiseHeldDaysForThisMonth;

    private Long practiseHeldDaysAllMonthCount;

    private PlayersDto playersDto;

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

    public Long getAttendanceForThisMonth() {
        return attendanceForThisMonth;
    }

    public void setAttendanceForThisMonth(Long attendanceForThisMonth) {
        this.attendanceForThisMonth = attendanceForThisMonth;
    }

    public Long getAttendanceAllMonthCount() {
        return attendanceAllMonthCount;
    }

    public void setAttendanceAllMonthCount(Long attendanceAllMonthCount) {
        this.attendanceAllMonthCount = attendanceAllMonthCount;
    }

    public Long getPractiseHeldDaysForThisMonth() {
        return practiseHeldDaysForThisMonth;
    }

    public void setPractiseHeldDaysForThisMonth(Long practiseHeldDaysForThisMonth) {
        this.practiseHeldDaysForThisMonth = practiseHeldDaysForThisMonth;
    }

    public Long getPractiseHeldDaysAllMonthCount() {
        return practiseHeldDaysAllMonthCount;
    }

    public void setPractiseHeldDaysAllMonthCount(Long practiseHeldDaysAllMonthCount) {
        this.practiseHeldDaysAllMonthCount = practiseHeldDaysAllMonthCount;
    }

    public PlayersDto getPlayersDto() {
        return playersDto;
    }

    public void setPlayersDto(PlayersDto playersDto) {
        this.playersDto = playersDto;
    }
}

