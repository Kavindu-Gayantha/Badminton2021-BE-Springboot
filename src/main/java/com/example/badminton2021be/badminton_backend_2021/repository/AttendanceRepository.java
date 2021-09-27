package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<AttendanceDomain, Long> {

    @Query("SELECT u FROM AttendanceDomain u WHERE u.attendantPlayer.registerDomain.id = :regId ")
    Iterable<AttendanceDomain> findAllByRegId(Long regId);
}
