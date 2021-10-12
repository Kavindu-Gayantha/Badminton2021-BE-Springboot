package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.SchedulePractiseDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchedulePractiseRepository extends CrudRepository<SchedulePractiseDomain, Long> {

    @Query("SELECT u FROM SchedulePractiseDomain u WHERE u.addedAdminId.university.id = :loginUserUniId")
    List<SchedulePractiseDomain> getAllByUniId(Long loginUserUniId);
}
