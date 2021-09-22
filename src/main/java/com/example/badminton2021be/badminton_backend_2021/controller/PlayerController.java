package com.example.badminton2021be.badminton_backend_2021.controller;

import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping(value = "/getAll/{loggedInUserUniId}")
    public ResponseDto getAllPlayers(@PathVariable("loggedInUserUniId") Long loggedInUserUniId){
        ResponseDto responseDto = playerService.getAllActivePlayers(loggedInUserUniId);
        return responseDto;
    }

    @PostMapping(value = "/create/{loggedInUserUniId}")
    public ResponseDto createPlayer(@RequestBody RegisterDto registerDto, @PathVariable("loggedInUserUniId") Long loggedInUserUniId){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("hiLL>>>>> " + auth);
        ResponseDto responseDto = playerService.createPlayer(registerDto, loggedInUserUniId);
        return responseDto;
    }

    @PutMapping(value = "/edit")
    public ResponseDto editPlayer(@RequestBody PlayersDto playersDto) {
        ResponseDto responseDto = playerService.editPlayer(playersDto);
        return responseDto;
    }

    @DeleteMapping(value = "/delete/{id}") // delete/3   API is like this
    public ResponseDto deletePlayer(@PathVariable Long id){
        ResponseDto responseDto = playerService.deletePlayer(id);
        return responseDto;
    }

    @GetMapping(value = "/getBoys/{loggedInUserUniId}")
    public ResponseDto getBoys(@PathVariable("loggedInUserUniId") Long loggedInUserUniId){
        ResponseDto responseDto = playerService.getAllActiveBoys(loggedInUserUniId);
        return responseDto;
    }
    @GetMapping(value = "/getGirls/{loggedInUserUniId}")
    public ResponseDto getGirls(@PathVariable("loggedInUserUniId") Long loggedInUserUniId){
        ResponseDto responseDto = playerService.getAllActiveGirls(loggedInUserUniId);
        return responseDto;
    }

    @GetMapping(value = "/regDataByEmail/{email}")
    public ResponseDto getPlayerRegDataByEmail(@PathVariable String email){
        ResponseDto responseDto = playerService.getPlayerRegDataByEmail(email);
        return responseDto;
    }


}
