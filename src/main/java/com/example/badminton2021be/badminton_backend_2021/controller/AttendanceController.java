package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.AttendanceDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @GetMapping(value = "/getIndividual/{regId}/{uniId}")
    public ResponseDto getIndividualAttendanceDetailsByRegId(@PathVariable("regId") Long regId,@PathVariable("uniId") Long uniId){
        ResponseDto responseDto = attendanceService.getIndividualAttendanceDetailsByRegId(regId, uniId);
        return responseDto;
    }
}
