package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.SchedulePractiseDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface SchedulePractiseService {
    ResponseDto getAllActiveSchedules(Long loginUserUniId);

    ResponseDto createSchedulePractise(SchedulePractiseDto schedulePractiseDto);
}
