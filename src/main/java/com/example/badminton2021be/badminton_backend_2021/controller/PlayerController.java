package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/getAll")
    public ResponseDto getAllPlayers(){
        ResponseDto responseDto = playerService.getAllActivePlayers();
        return responseDto;
    }

    @PostMapping(value = "/create")
    public ResponseDto createPlayer(@RequestBody PlayersDto playersDto){
        ResponseDto responseDto = playerService.createPlayer(playersDto);
        return responseDto;
    }

}
