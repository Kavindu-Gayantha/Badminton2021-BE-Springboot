package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.University;
import com.example.badminton2021be.badminton_backend_2021.dto.RegisterDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.PlayerRepository;
import com.example.badminton2021be.badminton_backend_2021.repository.RegisterRepository;
import com.example.badminton2021be.badminton_backend_2021.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    RegisterRepository registerRepository;

    @Autowired
    PlayerRepository playerRepository;


    @Transactional
    @Override
    public ResponseDto editMyProfile(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();

        if(registerDto != null) {
            System.out.println("register dto: " + registerDto.getFacultyIdForEditProfile());
            RegisterDomain existingRegUser = registerRepository.findByRegId(registerDto.getId());

            if(existingRegUser != null) {
                RegisterDomain convertedEditedRegisterPlayerObj = convertDtoToDomainReg(registerDto);

                // check for the email existing in the db already
                Optional<RegisterDomain> emailExistingCheckObj = registerRepository.findByEmail(convertedEditedRegisterPlayerObj.getEmail());

                if(emailExistingCheckObj.isPresent() && !emailExistingCheckObj.get().getEmail().equals(registerDto.getEmail())) {
                    responseDto.setStatusMessage(StatusMessages.ENTITY_ALREADY_EXIST_WITH_SAME_EMAIL.getStatusMessage());
                    responseDto.setStatus(false);
                    return responseDto;
                } else {
                    // user type and the university should not be changed.
                    existingRegUser.setId(existingRegUser.getId());
                    existingRegUser.setFirstName(convertedEditedRegisterPlayerObj.getFirstName() != null ? convertedEditedRegisterPlayerObj.getFirstName() : existingRegUser.getFirstName());
                    existingRegUser.setGender(convertedEditedRegisterPlayerObj.getGender() != null ? convertedEditedRegisterPlayerObj.getGender(): existingRegUser.getGender());
                    existingRegUser.setLastName(convertedEditedRegisterPlayerObj.getLastName() != null ? convertedEditedRegisterPlayerObj.getLastName(): existingRegUser.getLastName());
//                    existingRegUser.setPassword((convertedEditedRegisterPlayerObj.getPassword() != null || convertedEditedRegisterPlayerObj.getPassword() != "") ? convertedEditedRegisterPlayerObj.getPassword(): existingRegUser.getPassword());
                    existingRegUser.setEmail(convertedEditedRegisterPlayerObj.getEmail() != null ? convertedEditedRegisterPlayerObj.getEmail() : existingRegUser.getEmail());

                    // no email duplication here. now can store in db
                    existingRegUser = registerRepository.save(existingRegUser);

                    // change in player table also
                    // check the email is in the player table or not. if yes => set the reg id in there. if not set the object in the player table too
                    Optional<Players> playerObjWithEmail = playerRepository.getByRegId(existingRegUser.getId());

                    if(playerObjWithEmail.isPresent()){ // check the registered email is already in the player table or not
                        Players existingPlayer = playerObjWithEmail.get();

                        existingPlayer.setName(existingRegUser.getFirstName());
                        existingPlayer.setEmail(existingRegUser.getEmail());
                        existingPlayer.setGender(existingRegUser.getGender());
//                        existingPlayer.setFaculty(registerDto.getFacultyIdForEditProfile());

                        existingPlayer = playerRepository.save(existingPlayer);

                    }

                    responseDto.setStatus(true);
                    responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_UPDATED.getStatusMessage());
                    responseDto.setData(existingRegUser);
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
//        return null;
    }

    @Override
    public ResponseDto transferAdminProfile(RegisterDto registerDto) {
        ResponseDto responseDto = new ResponseDto();

        if(registerDto != null){
            RegisterDomain convertedRegisterDomain = convertDtoToDomainReg(registerDto);

            if(convertedRegisterDomain != null){
                Optional<RegisterDomain> uniAdminExistingOptional = registerRepository.getAdminByUniId(registerDto.getUniversity());

                if(uniAdminExistingOptional.isPresent()){
                    uniAdminExistingOptional.get().setDeleted(true);
                    registerRepository.save(uniAdminExistingOptional.get()); // delete existing Admin

                    convertedRegisterDomain = registerRepository.save(convertedRegisterDomain);
                    responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_ADMIN_CHANGED.getStatusMessage());
                    responseDto.setStatus(true);
                    responseDto.setData(convertedRegisterDomain);
                    return responseDto;

                } else {
                    responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                    responseDto.setStatus(false);
                    return responseDto;
                }
            }
        }  else {
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            responseDto.setStatus(false);
            return responseDto;
        }
        return null;
    }

    private RegisterDomain convertDtoToDomainReg(RegisterDto registerDto) {
        RegisterDomain registerDomain = new RegisterDomain();

        registerDomain.setDeleted(false);
        registerDomain.setEmail(registerDto.getEmail());
        registerDomain.setGender(registerDto.getGender());
        registerDomain.setFirstName(registerDto.getFirstName());
        registerDomain.setActive(true);
        registerDomain.setLastName(registerDto.getLastName());
//        registerDomain.setPassword(registerDto.getPassword());

//        University university = new University();
//        university.setId(registerDto.getUniversity());
//        registerDomain.setUniversity(university);

//        registerDomain.setUserType(registerDto.getUserType());

        return registerDomain;
    }
}
