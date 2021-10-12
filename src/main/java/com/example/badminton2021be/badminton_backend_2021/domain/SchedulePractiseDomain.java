package com.example.badminton2021be.badminton_backend_2021.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "practise_schedule_table")
public class SchedulePractiseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practise_schedule_id")
    private Long id;

    private Date dateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_admin_register_id")
    private RegisterDomain addedAdminId;

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

    public RegisterDomain getAddedAdminId() {
        return addedAdminId;
    }

    public void setAddedAdminId(RegisterDomain addedAdminId) {
        this.addedAdminId = addedAdminId;
    }
}
