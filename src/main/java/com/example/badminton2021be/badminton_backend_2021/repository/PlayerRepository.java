package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Players, Long> {

    @Query("SELECT u FROM Players u WHERE u.deleted = false order by u.id desc")
    List<Players> getAllActivePlayers();

    @Query("SELECT u FROM Players u WHERE u.deleted = false AND u.gender = :male ")
    List<Players> getAllActiveBoys(String male);

    @Query("SELECT u FROM Players u WHERE u.deleted = false AND u.gender = :female ")
    List<Players> getAllActiveGirls(String female);

    @Query("SELECT u FROM Players u WHERE u.email = :email AND u.deleted = false ")
    Optional<Players> findByEmail(String email);
}
