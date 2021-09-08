package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.University;
import com.example.badminton2021be.badminton_backend_2021.dto.LoginDto;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.PlayerRepository;
import com.example.badminton2021be.badminton_backend_2021.repository.RegisterRepository;
import com.example.badminton2021be.badminton_backend_2021.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Transactional
    @Override
    public ResponseDto registerUser(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();

        if(registerDto != null) {
            RegisterDomain convertedRegDomain = convertRegDtoToDomain(registerDto);

            // check the email duplication in db
            Optional<RegisterDomain> registerObjectWithEmail = registerRepository.findByEmail(convertedRegDomain.getEmail());

            if(registerObjectWithEmail.isPresent()){
                responseDto.setStatusMessage(StatusMessages.ENTITY_ALREADY_EXIST_WITH_SAME_EMAIL.getStatusMessage());
                responseDto.setStatus(false);
                return responseDto;
            } else {
                // save domain in the db
                RegisterDomain persistedRegObject = registerRepository.save(convertedRegDomain);
//                responseDto.setData(persistedRegObject);

                // check the email is in the player table or not. if yes => set the reg id in there. if not set the object in the player table too
                Optional<Players> playerObjWithEmail = playerRepository.findByEmail(persistedRegObject.getEmail());

                if(playerObjWithEmail.isPresent()){ // check the registered email is already in the player table or not
                    Players existingPlayer = playerObjWithEmail.get();

                    RegisterDomain registerDomain = new RegisterDomain();
                    registerDomain.setId(persistedRegObject.getId());
                    existingPlayer.setRegisterDomain(registerDomain); // set registration id into the object which has the same email in the player.

                    existingPlayer = playerRepository.save(existingPlayer);

                } else {
                    // reg email is not in the player table. so put the reg object in player table
                    Players newlyRegisteredPlayer = new Players();

                    RegisterDomain registerDomain = new RegisterDomain();
                    registerDomain.setId(persistedRegObject.getId());
                    newlyRegisteredPlayer.setRegisterDomain(registerDomain);

//                    newlyRegisteredPlayer.setFaculty();
                    newlyRegisteredPlayer.setDeleted(false);
                    newlyRegisteredPlayer.setName(persistedRegObject.getFirstName());
                    newlyRegisteredPlayer.setGender(persistedRegObject.getGender());
                    newlyRegisteredPlayer.setEmail(persistedRegObject.getEmail());

                    newlyRegisteredPlayer = playerRepository.save(newlyRegisteredPlayer); // added new player which registered newly
                }

                responseDto.setData(persistedRegObject);
                responseDto.setStatus(true);
                responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());

                return responseDto;
            }

        } else {
            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            return responseDto;
        }

    }

    @Override
    public ResponseDto loginUser(LoginDto loginDto) {
        ResponseDto responseDto = new ResponseDto();
        if(loginDto != null) {
            // check the username in register table
            RegisterDomain checkUser = registerRepository.findUserByEmail(loginDto.getEmail());
            // if yes, check with the password is correct or not
            if(checkUser != null) {
                if(checkUser.getPassword().equals(loginDto.getPassword())){
                    responseDto.setStatus(true);
                    responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_LOGIN.getStatusMessage());
                    responseDto.setData(checkUser.getEmail());

                    return responseDto;
                } else {
                    responseDto.setStatusMessage(StatusMessages.INVALID_USER_PASSWORD.getStatusMessage());
                    responseDto.setStatus(false);
                    return responseDto;
                }
            } else {
                responseDto.setStatus(false);
                responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                return responseDto;
            }
        } else {
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            responseDto.setStatus(false);
            return responseDto;
        }

    }

    private RegisterDomain convertRegDtoToDomain(RegisterDto registerDto) {
        RegisterDomain registerDomain = new RegisterDomain();

        registerDomain.setDeleted(false);
        registerDomain.setEmail(registerDto.getEmail());
        registerDomain.setGender(registerDto.getGender());
        registerDomain.setFirstName(registerDto.getFirstName());
        registerDomain.setActive(true);
        registerDomain.setLastName(registerDto.getLastName());
        registerDomain.setPassword(registerDto.getPassword());

        University university = new University();
        university.setId(registerDto.getUniversity());
        registerDomain.setUniversity(university);

        registerDomain.setUserType(registerDto.getUserType());

        return registerDomain;
    }
}
