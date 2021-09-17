package com.example.badminton2021be.badminton_backend_2021.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "attendance_marking")
public class AttendanceDomain {

    @Id
    @Column(name="attendanct_table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_id")
    private RegisterDomain addedAdminRegId;

    private Date date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_Id")
    private Players attendantPlayer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegisterDomain getAddedAdminRegId() {
        return addedAdminRegId;
    }

    public void setAddedAdminRegId(RegisterDomain addedAdminRegId) {
        this.addedAdminRegId = addedAdminRegId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Players getAttendantPlayer() {
        return attendantPlayer;
    }

    public void setAttendantPlayer(Players attendantPlayer) {
        this.attendantPlayer = attendantPlayer;
    }
}
