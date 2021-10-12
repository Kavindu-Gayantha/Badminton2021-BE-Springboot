package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.SchedulePractiseDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.SchedulePractiseDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.SchedulePractiseRepository;
import com.example.badminton2021be.badminton_backend_2021.service.SchedulePractiseService;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulePractiseServiceImpl implements SchedulePractiseService {
    @Autowired
    SchedulePractiseRepository schedulePractiseRepository;

    @Override
    public ResponseDto getAllActiveSchedules(Long loginUserUniId) {
        ResponseDto responseDto = new ResponseDto();

        if (loginUserUniId != null) {

            List<SchedulePractiseDomain> schedulePractiseDomainList = schedulePractiseRepository.getAllByUniId(loginUserUniId);
            List<SchedulePractiseDto> schedulePractiseDtosList = new ArrayList<SchedulePractiseDto>();

            if(schedulePractiseDomainList != null) {
                for(SchedulePractiseDomain oneRowObj: schedulePractiseDomainList){
                    SchedulePractiseDto convertedScheduleDto = convertScheduleDomainToDto(oneRowObj);
                    schedulePractiseDtosList.add(convertedScheduleDto);
                }

                responseDto.setStatus(true);
                responseDto.setData(schedulePractiseDtosList);
                responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
                return responseDto;
            }
        } else {

            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            return responseDto;

        }
        return responseDto;
    }

    private SchedulePractiseDto convertScheduleDomainToDto(SchedulePractiseDomain oneRowObj) {
        SchedulePractiseDto schedulePractiseDto = new SchedulePractiseDto();

        schedulePractiseDto.setId(oneRowObj.getId());
        schedulePractiseDto.setAddedAdminId(oneRowObj.getAddedAdminId().getId());
        schedulePractiseDto.setDateTime(oneRowObj.getDateTime());
        return schedulePractiseDto;
    }

    @Transactional
    @Override
    public ResponseDto createSchedulePractise(SchedulePractiseDto schedulePractiseDto) {
        ResponseDto responseDto = new ResponseDto();

        if(schedulePractiseDto != null) {

            SchedulePractiseDomain convertedScheduleDtoToDomain = convertScheduleDtoToDomain(schedulePractiseDto);

            if(convertedScheduleDtoToDomain != null) {

                SchedulePractiseDomain persistedObj = schedulePractiseRepository.save(convertedScheduleDtoToDomain);

                responseDto.setStatus(true);
                responseDto.setData(persistedObj);
                responseDto.setStatusMessage(StatusMessages.CREATED_SUCCESSFULLY.getStatusMessage());
                return responseDto;

            } else {

                responseDto.setStatus(false);
                responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                return responseDto;

            }
        }else {

            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            return responseDto;

        }

    }

    private SchedulePractiseDomain convertScheduleDtoToDomain(SchedulePractiseDto schedulePractiseDto) {
        SchedulePractiseDomain schedulePractiseDomain = new SchedulePractiseDomain();

        schedulePractiseDomain.setDateTime(schedulePractiseDto.getDateTime());

        RegisterDomain registerDomain = new RegisterDomain();
        registerDomain.setId(schedulePractiseDto.getAddedAdminId());
        schedulePractiseDomain.setAddedAdminId(registerDomain);

        return schedulePractiseDomain;
    }
}
