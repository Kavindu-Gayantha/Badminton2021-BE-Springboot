package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegisterRepository extends CrudRepository<RegisterDomain, Long> {

    @Query("SELECT u FROM RegisterDomain u WHERE u.email = :email and u.deleted = false ")
    Optional<RegisterDomain> findByEmail(String email);
}
