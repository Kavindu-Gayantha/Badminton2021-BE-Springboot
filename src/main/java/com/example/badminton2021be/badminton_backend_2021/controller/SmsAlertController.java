package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.SmsAlertDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.repository.SmsAlertRepository;
import com.example.badminton2021be.badminton_backend_2021.service.SmsAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sms")
public class SmsAlertController {
    @Autowired
    SmsAlertService smsAlertService;

    @GetMapping(value = "/getAll")
    public ResponseDto getAllSmsAlerts(){
        ResponseDto responseDto = smsAlertService.getAllSmsAlerts();
        return responseDto;
    }

    @PostMapping(value = "/create")
    public ResponseDto createSmsAlert(@RequestBody SmsAlertDto smsAlertDto){
        ResponseDto responseDto = smsAlertService.createSmsAlert(smsAlertDto);
        return responseDto;
    }
}
