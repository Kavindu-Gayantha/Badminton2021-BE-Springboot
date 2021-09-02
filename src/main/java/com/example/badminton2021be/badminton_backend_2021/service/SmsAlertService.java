package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.SmsAlertDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface SmsAlertService {
    ResponseDto getAllSmsAlerts();

    ResponseDto createSmsAlert(SmsAlertDto smsAlertDto);
}
