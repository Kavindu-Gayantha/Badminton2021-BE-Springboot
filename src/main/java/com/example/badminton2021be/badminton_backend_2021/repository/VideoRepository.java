package com.example.badminton2021be.badminton_backend_2021.repository;

import com.example.badminton2021be.badminton_backend_2021.domain.VideoDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VideoRepository extends CrudRepository<VideoDomain, Long> {

    @Query("SELECT u FROM VideoDomain u order by u.id desc ")
    List<VideoDomain> findAllLinks();
}
