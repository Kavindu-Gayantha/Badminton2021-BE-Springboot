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

    private SmsAlertDto convertSmsAlertDomainToDto(SmsAlertDomain smsAlertOne) {
        SmsAlertDto smsAlertDto = new SmsAlertDto();
        smsAlertDto.setId(smsAlertOne.getId());
        smsAlertDto.setMsg(smsAlertOne.getMsg());
        smsAlertDto.setTimestamp(smsAlertOne.getTimestamp());
        return smsAlertDto;
    }
}
