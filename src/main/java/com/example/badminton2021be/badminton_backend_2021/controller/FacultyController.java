package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @GetMapping(value = "/getAllActive/{loggedInUserUniId}")
    public ResponseDto getAllActiveFaculty(@PathVariable("loggedInUserUniId") Long loginUserUniId) {
        ResponseDto responseDto = facultyService.getAllActive(loginUserUniId);
        return responseDto;
    }
}
