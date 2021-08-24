package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.dto.FacultyDto;
import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.PlayerRepository;
import com.example.badminton2021be.badminton_backend_2021.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public ResponseDto getAllActivePlayers() {
        ResponseDto responseDto = new ResponseDto();
        List<Players> playersList = playerRepository.getAllActivePlayers();
        List<PlayersDto> playersDtoList = new ArrayList<PlayersDto>();

//        if (!playersList.isEmpty()){
            for(Players players: playersList){
                playersDtoList.add(convertPlayersDomainToDto(players));
            }
            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
            responseDto.setData(playersDtoList);

//        } else {
//            responseDto.setStatus(true);
//            responseDto.setStatusMessage(StatusMessages..getStatusMessage());
//
//        }
        return responseDto;

    }

    private PlayersDto convertPlayersDomainToDto(Players players) {
        PlayersDto playersDto = new PlayersDto();

        playersDto.setId(players.getId());
        playersDto.setName(players.getName());

//        FacultyDto facultyDto = new FacultyDto();
//        facultyDto.setId(players.getFacultyId().getId());
//        facultyDto.setFaculty(players.getFacultyId().getFacultyName());

        playersDto.setFaculty(players.getFacultyId().getFacultyName());
        playersDto.setGender(players.getGender());
        playersDto.setDeleted(players.getDeleted());

        return playersDto;
    }
}
