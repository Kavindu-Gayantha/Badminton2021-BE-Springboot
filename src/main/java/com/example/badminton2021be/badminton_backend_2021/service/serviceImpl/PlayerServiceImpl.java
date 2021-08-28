package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Faculty;
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
import java.util.Optional;

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

    @Override
    public ResponseDto createPlayer(PlayersDto playersDto) {
        ResponseDto responseDto = new ResponseDto();

        if(playersDto != null) {
            Players players = convertPlayerDtoToDomain(playersDto);

            if(players != null) {

                Players playersAfterSave = playerRepository.save(players);
                responseDto.setStatus(true);
                responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());
                responseDto.setData(playersAfterSave);
                return responseDto;

            } else {
                responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
                responseDto.setStatus(false);
                return responseDto;
            }
        } else {
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            responseDto.setStatus(false);
            return responseDto;
        }

    }

    @Override
    public ResponseDto getAllActiveBoys() {
        ResponseDto responseDto = new ResponseDto();

        List<Players> allBoysList = playerRepository.getAllActiveBoys("Male");
        List<PlayersDto> allBoysDto = new ArrayList<PlayersDto>();

        for (Players boyPlayer : allBoysList) {
            PlayersDto oneBoyPlayer = convertPlayersDomainToDto(boyPlayer);
            allBoysDto.add(oneBoyPlayer);
        }
        if (allBoysDto != null) {
        responseDto.setStatus(true);
        responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
        responseDto.setData(allBoysDto);
    }

        return responseDto;
    }

    @Override
    public ResponseDto getAllActiveGirls() {
        ResponseDto responseDto = new ResponseDto();

        List<Players> allGirlsList = playerRepository.getAllActiveGirls("Female");
        List<PlayersDto> allGirlsDto = new ArrayList<PlayersDto>();

        for (Players girlPlayer : allGirlsList) {
            PlayersDto oneGirlPlayer = convertPlayersDomainToDto(girlPlayer);
            allGirlsDto.add(oneGirlPlayer);
        }
        if (allGirlsDto != null) {
            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
            responseDto.setData(allGirlsDto);
        }

        return responseDto;
    }

    @Override
    public ResponseDto editPlayer(PlayersDto playersDto) {
        ResponseDto responseDto = new ResponseDto();

        if(playersDto != null) {
            Optional<Players> getPlayerByIdOptional = playerRepository.findById(playersDto.getId());

            if(getPlayerByIdOptional.isPresent()){
                Players getExistingPlayerById = getPlayerByIdOptional.get();
                if(getExistingPlayerById != null) {
                    Players newUpdatedPlayerDomain = convertPlayerDtoToDomain(playersDto);
                    getExistingPlayerById.setFaculty(newUpdatedPlayerDomain.getFaculty() != null ? newUpdatedPlayerDomain.getFaculty(): getExistingPlayerById.getFaculty());
                    getExistingPlayerById.setName(newUpdatedPlayerDomain.getName() != null ? newUpdatedPlayerDomain.getName() : getExistingPlayerById.getName());
                    getExistingPlayerById.setGender(newUpdatedPlayerDomain.getGender() != null ? newUpdatedPlayerDomain.getGender() : getExistingPlayerById.getGender());
                    getExistingPlayerById.setDeleted(getExistingPlayerById.getDeleted());
                    getExistingPlayerById.setId(getExistingPlayerById.getId());
                    getExistingPlayerById = playerRepository.save(getExistingPlayerById);

                    responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_UPDATED.getStatusMessage());
                    responseDto.setStatus(true);
                    responseDto.setData(getExistingPlayerById);
                    return responseDto;
                }

            } else {
                responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                responseDto.setStatus(false);
                return responseDto;
            }
        } else {
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            responseDto.setStatus(false);
            return responseDto;
        }
        return responseDto;
    }

    @Override
    public ResponseDto deletePlayer(Long id) {
        ResponseDto responseDto = new ResponseDto();
        if(id != null) {
            Optional<Players> getPlayerOptionalById = playerRepository.findById(id);

            if(getPlayerOptionalById.isPresent()){
                Players existingPlayer = getPlayerOptionalById.get();

                if(existingPlayer != null){
                    existingPlayer.setDeleted(true);
                    existingPlayer = playerRepository.save(existingPlayer);

                    responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_DELETED.getStatusMessage());
                    responseDto.setStatus(true);
                    responseDto.setData(existingPlayer);
                    return responseDto;
                }

            } else {
                responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                responseDto.setStatus(false);
                return responseDto;
            }

        } else {
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            responseDto.setStatus(false);
            return responseDto;
        }
        return null;
    }

    private Players convertPlayerDtoToDomain(PlayersDto playersDto) {
        Players players = new Players();

        players.setDeleted(false);
        players.setGender(playersDto.getGender());
        players.setName(playersDto.getName());
        players.setFaculty(playersDto.getFacultyName());

        return players;
    }

    private PlayersDto convertPlayersDomainToDto(Players players) {
        PlayersDto playersDto = new PlayersDto();

        playersDto.setId(players.getId());
        playersDto.setName(players.getName());

//        FacultyDto facultyDto = new FacultyDto();
//        facultyDto.setId(players.getFacultyId().getId());
//        facultyDto.setFaculty(players.getFacultyId().getFacultyName());

        playersDto.setFacultyName(players.getFaculty());
        playersDto.setGender(players.getGender());
        playersDto.setDeleted(players.getDeleted());

        return playersDto;
    }
}
