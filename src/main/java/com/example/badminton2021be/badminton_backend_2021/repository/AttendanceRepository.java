package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<AttendanceDomain, Long> {
}
