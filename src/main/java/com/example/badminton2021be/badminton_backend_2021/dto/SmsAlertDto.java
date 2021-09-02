package com.example.badminton2021be.badminton_backend_2021.dto;

import java.util.Date;

public class SmsAlertDto {

    private Long id;

    private Date timestamp;

    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
