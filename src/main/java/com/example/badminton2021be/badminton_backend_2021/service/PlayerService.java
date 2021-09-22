package com.example.badminton2021be.badminton_backend_2021.service;

import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;

public interface PlayerService {

    ResponseDto getAllActivePlayers(Long loggedInUserUniId);

    ResponseDto createPlayer(RegisterDto registerDto, Long loggedInUserUniId);

    ResponseDto getAllActiveBoys(Long loggedInUserUniId);

    ResponseDto getAllActiveGirls(Long loggedInUserUniId);

    ResponseDto editPlayer(PlayersDto playersDto);

    ResponseDto deletePlayer(Long id);

    ResponseDto getPlayerRegDataByEmail(String email);
}
