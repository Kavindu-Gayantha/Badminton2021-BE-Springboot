package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.SmsAlertDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SmsAlertRepository extends CrudRepository<SmsAlertDomain, Long> {

    @Query("SELECT u FROM SmsAlertDomain u order by current_time ")
    List<SmsAlertDomain> getAllActiveSms();
}
