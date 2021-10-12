package com.example.badminton2021be.badminton_backend_2021.controller;


import com.example.badminton2021be.badminton_backend_2021.dto.SchedulePractiseDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.SchedulePractiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/schedule")
public class SchedulePractiseController {
    @Autowired
    SchedulePractiseService schedulePractiseService;

    @GetMapping(value = "/getAllByUniId/{loggedInUserUniId}")
    public ResponseDto getAllActiveSchedules(@PathVariable("loggedInUserUniId") Long loginUserUniId) {
        ResponseDto responseDto = schedulePractiseService.getAllActiveSchedules(loginUserUniId);
        return responseDto;
    }
    @PostMapping(value = "/createSchedule")
    public ResponseDto createSchedulePractise(@RequestBody SchedulePractiseDto schedulePractiseDto) {
        ResponseDto responseDto = schedulePractiseService.createSchedulePractise(schedulePractiseDto);
        return responseDto;
    }
}
