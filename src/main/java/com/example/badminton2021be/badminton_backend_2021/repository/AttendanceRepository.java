package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AttendanceRepository extends CrudRepository<AttendanceDomain, Long> {

    @Query("SELECT u FROM AttendanceDomain u WHERE u.attendantPlayer.registerDomain.id = :regId ")
    Iterable<AttendanceDomain> findAllByRegId(Long regId);

    @Query("SELECT count(u.id) FROM AttendanceDomain u WHERE u.date BETWEEN :fromDate AND :toDate")
    List<AttendanceDomain> findDatesCountOfThisMonth(String fromDate, String toDate);

    @Query("SELECT u FROM AttendanceDomain u WHERE u.attendantPlayer.registerDomain.id = :regId")
    List<AttendanceDomain> findDatesCountOfAllTime(Long regId);

    @Query("SELECT DISTINCT(u) FROM AttendanceDomain u WHERE  u.addedAdminRegId.university.id = :uniId ")
    List<AttendanceDomain> findDatesCountOfAllTimeByAddedAdmin(Long uniId);
}
