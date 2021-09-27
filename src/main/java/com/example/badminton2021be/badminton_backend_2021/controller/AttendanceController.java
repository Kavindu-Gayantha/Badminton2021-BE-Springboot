package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.AttendanceDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping(value = "/submit")
    public ResponseDto attendanceMarking(@RequestBody AttendanceDto attendanceDto){
        ResponseDto responseDto = attendanceService.attendanceMarking(attendanceDto);
        return responseDto;
    }

    @GetMapping(value = "/getIndividual/{regId}")
    public ResponseDto getIndividualAttendanceDetailsByRegId(@PathVariable("regId") Long regId ){
        ResponseDto responseDto = attendanceService.getIndividualAttendanceDetailsByRegId(regId);
        return responseDto;
    }
}
