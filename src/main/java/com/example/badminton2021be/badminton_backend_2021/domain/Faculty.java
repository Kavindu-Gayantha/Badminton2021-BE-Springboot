package com.example.badminton2021be.badminton_backend_2021.domain;

import javax.persistence.*;

@Entity
@Table(name="faculty")
public class Faculty {

    @Id
    @Column(name = "faculty_id")
    private Long id;

    private String facultyName;

    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
