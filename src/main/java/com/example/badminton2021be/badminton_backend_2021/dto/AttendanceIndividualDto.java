package com.example.badminton2021be.badminton_backend_2021.dto;

import java.util.Date;

public class AttendanceIndividualDto {

    private Long regId;

    private Long addedAdminRegId;

    private Number totalPracticeDaysCount;

    private Long[] attendedDateDetailsIndividuals;

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public Long getAddedAdminRegId() {
        return addedAdminRegId;
    }

    public void setAddedAdminRegId(Long addedAdminRegId) {
        this.addedAdminRegId = addedAdminRegId;
    }

    public Number getTotalPracticeDaysCount() {
        return totalPracticeDaysCount;
    }

    public void setTotalPracticeDaysCount(Number totalPracticeDaysCount) {
        this.totalPracticeDaysCount = totalPracticeDaysCount;
    }

    public Long[] getAttendedDateDetailsIndividuals() {
        return attendedDateDetailsIndividuals;
    }

    public void setAttendedDateDetailsIndividuals(Long[] attendedDateDetailsIndividuals) {
        this.attendedDateDetailsIndividuals = attendedDateDetailsIndividuals;
    }
}
