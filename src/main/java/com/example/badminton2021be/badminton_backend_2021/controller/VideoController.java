package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping(value = "/getAll")
    public ResponseDto getAllVideoLinks() {
        ResponseDto responseDto = videoService.getAllVideoLinks();
        return responseDto;
    }
}
