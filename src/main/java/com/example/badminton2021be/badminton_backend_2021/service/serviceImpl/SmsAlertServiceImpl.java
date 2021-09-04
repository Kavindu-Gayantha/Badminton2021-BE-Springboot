package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.SmsAlertDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.SmsAlertDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.SmsAlertRepository;
import com.example.badminton2021be.badminton_backend_2021.service.SmsAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SmsAlertServiceImpl implements SmsAlertService {
   @Autowired
    SmsAlertRepository smsAlertRepository;

    @Override
    public ResponseDto getAllSmsAlerts() {
        ResponseDto responseDto = new ResponseDto();

        List<SmsAlertDomain> getAllSms = smsAlertRepository.getAllActiveSms();
        List<SmsAlertDto> alertDtoList = new ArrayList<SmsAlertDto>();

        for(SmsAlertDomain smsAlertOne: getAllSms){
            SmsAlertDto smsAlertDto = convertSmsAlertDomainToDto(smsAlertOne);
            alertDtoList.add(smsAlertDto);
        }
//            alertDtoList = smsAlertRepository.save(alertDtoList);
            responseDto.setStatus(true);
            responseDto.setData(alertDtoList);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());

        return responseDto;
//        return null;
    }

    @Override
    public ResponseDto createSmsAlert(SmsAlertDto smsAlertDto) {
        ResponseDto responseDto = new ResponseDto();
        if(smsAlertDto != null) {
            SmsAlertDomain convertedSms = convertSmsAlertDtoToDomain(smsAlertDto);

            if(convertedSms != null){
                convertedSms = smsAlertRepository.save(convertedSms);
                responseDto.setData(convertedSms);
                responseDto.setStatus(true);
                responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());
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
//        return null;
    }

    private SmsAlertDomain convertSmsAlertDtoToDomain(SmsAlertDto smsAlertDto) {
        SmsAlertDomain smsAlertDomain = new SmsAlertDomain();
        smsAlertDomain.setMsg(smsAlertDto.getMsg());
        smsAlertDomain.setTimestamp(new Date());
        return smsAlertDomain;
    }

    private SmsAlertDto convertSmsAlertDomainToDto(SmsAlertDomain smsAlertOne) {
        SmsAlertDto smsAlertDto = new SmsAlertDto();
        smsAlertDto.setId(smsAlertOne.getId());
        smsAlertDto.setMsg(smsAlertOne.getMsg());
        smsAlertDto.setTimestamp(smsAlertOne.getTimestamp());
        return smsAlertDto;
    }
}
