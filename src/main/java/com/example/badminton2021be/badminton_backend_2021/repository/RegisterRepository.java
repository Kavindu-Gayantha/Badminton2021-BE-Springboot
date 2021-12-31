package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegisterRepository extends CrudRepository<RegisterDomain, Long> {

    @Query("SELECT u FROM RegisterDomain u WHERE u.email = :email and u.deleted = false ")
    Optional<RegisterDomain> findByEmail(String email);

    @Query("SELECT u FROM RegisterDomain u WHERE u.email = :email and u.deleted = false AND u.isActive = true ")
    RegisterDomain findUserByEmail(String email);

    @Query("SELECT u FROM RegisterDomain u WHERE u.university.id = :id AND u.userType = :userRole AND u.isActive = true AND u.deleted = false ")
    Optional<RegisterDomain> findByUniIdAndAdmin(Long id, String userRole);

    @Query("SELECT u FROM RegisterDomain u WHERE u.id = :id AND u.deleted = false AND u.isActive = true " )
    RegisterDomain findByRegId(Long id);

    @Query("SELECT u FROM RegisterDomain u WHERE u.university.id = :id AND u.userType = 'Admin' AND u.deleted = false ")
    Optional<RegisterDomain> getAdminByUniId(Long id);
}
