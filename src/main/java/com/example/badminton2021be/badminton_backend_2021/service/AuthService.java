package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.LoginDto;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface AuthService {
    ResponseDto registerUser(RegisterDto registerDto);

    ResponseDto loginUser(LoginDto loginDto);
}
