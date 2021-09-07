package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(value = "/register")
    public ResponseDto registerUser(@RequestBody RegisterDto registerDto){
        ResponseDto responseDto = authService.registerUser(registerDto);
        return responseDto;
    }
}
