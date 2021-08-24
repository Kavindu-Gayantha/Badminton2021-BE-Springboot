package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends CrudRepository<Faculty, Long> {

    @Query("SELECT u FROM Faculty u WHERE u.deleted = false")
    List<Faculty> getAllActive();
}
