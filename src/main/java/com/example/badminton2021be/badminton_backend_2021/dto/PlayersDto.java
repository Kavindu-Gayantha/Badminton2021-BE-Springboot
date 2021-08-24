package com.example.badminton2021be.badminton_backend_2021.dto;

public class PlayersDto {

    private Long id;

    private String name;

//    private Long facultyId;

    private String facultyName;

    private Boolean deleted;

    private String gender;

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

//    public Long getFacultyId() {
//        return facultyId;
//    }
//
//    public void setFacultyId(Long facultyId) {
//        this.facultyId = facultyId;
//    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
