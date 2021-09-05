package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.VideoDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface VideoService {
    ResponseDto getAllVideoLinks();

    ResponseDto createVideoLink(VideoDto videoDto);
}
