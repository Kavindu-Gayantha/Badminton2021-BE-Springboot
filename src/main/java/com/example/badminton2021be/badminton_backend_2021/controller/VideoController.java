package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.VideoDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/create")
    public ResponseDto createVideoLink(@RequestBody VideoDto videoDto){
        ResponseDto responseDto = videoService.createVideoLink(videoDto);
        return responseDto;
    }
}
