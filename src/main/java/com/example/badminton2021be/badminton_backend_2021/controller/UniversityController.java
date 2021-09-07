package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.FacultyService;
import com.example.badminton2021be.badminton_backend_2021.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class UniversityController {

    @RestController
    @RequestMapping(value = "/university")
    public class FacultyController {
        @Autowired
        UniversityService universityService;

        @GetMapping(value = "/getAllActive")
        public ResponseDto getAllActiveUniversities() {
            ResponseDto responseDto = universityService.getAllActive();
            return responseDto;
        }
    }
}
