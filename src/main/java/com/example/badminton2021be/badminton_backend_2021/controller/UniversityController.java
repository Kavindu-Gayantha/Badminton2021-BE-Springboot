package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.PlayerService;
import com.example.badminton2021be.badminton_backend_2021.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/universities")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping(value = "/getAll")
    public ResponseDto getAllUniversities(){
        ResponseDto responseDto = universityService.getAllActive();
        return responseDto;
    }
}
