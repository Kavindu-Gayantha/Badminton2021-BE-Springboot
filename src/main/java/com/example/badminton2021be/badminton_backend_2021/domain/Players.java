package com.example.badminton2021be.badminton_backend_2021.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="players")
public class Players {

    @Id
    @Column(name="player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String gender;

    private String faculty;

    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register_id")
    private RegisterDomain registerDomain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterDomain getRegisterDomain() {
        return registerDomain;
    }

    public void setRegisterDomain(RegisterDomain registerDomain) {
        this.registerDomain = registerDomain;
    }
}
