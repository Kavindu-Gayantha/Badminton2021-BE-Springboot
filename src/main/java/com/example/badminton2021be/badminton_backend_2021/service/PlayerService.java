package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface PlayerService {

    ResponseDto getAllActivePlayers();

    ResponseDto createPlayer(PlayersDto playersDto);

    ResponseDto getAllActiveBoys();
}
