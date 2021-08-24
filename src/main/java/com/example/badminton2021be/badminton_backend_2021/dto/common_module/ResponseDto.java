package com.example.badminton2021be.badminton_backend_2021.dto.common_module;

import java.io.Serializable;

public class ResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean status;

    private String statusMessage;

    private Object data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
