package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.AttendanceDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.AttendanceRepository;
import com.example.badminton2021be.badminton_backend_2021.service.AttendanceService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public ResponseDto attendanceMarking(AttendanceDto attendanceDto) {
        ResponseDto responseDto = new ResponseDto();

        if(attendanceDto != null ) {
//            AttendanceDomain convertedAttendantPlayerData = convertAttendanceDtoToDomain(attendanceDto);
            //TODO - check the date is already is given


            for(int i = 0; i <  attendanceDto.getAttendantPlayerIds().length; i++){
                AttendanceDomain attendanceDomain = new AttendanceDomain();

                RegisterDomain registerDomain = new RegisterDomain();
                registerDomain.setId(attendanceDto.getAddedAdminRegId());
                attendanceDomain.setAddedAdminRegId(registerDomain);

                attendanceDomain.setDate(attendanceDto.getDate());

                Players players = new Players();
                players.setId(attendanceDto.getAttendantPlayerIds()[i]);
                attendanceDomain.setAttendantPlayer(players);

                AttendanceDomain persistedObj = attendanceRepository.save(attendanceDomain);

//                responseDto.setData(persistedObj);
//                responseDto.setStatus(true);
//                responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());

            }
//            responseDto.setData();
            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());
            return responseDto;
        }
        responseDto.setStatus(false);
        responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());

        return responseDto;

    }

    @Override
    public ResponseDto getIndividualAttendanceDetailsByRegId(Long regId) {
        ResponseDto responseDto = new ResponseDto();

        if(regId != null){
            //GET ALL THE DATES INDIVIDUAL ATTENDED
            Iterable<AttendanceDomain> listOfAttendanceByRegIdIterable = attendanceRepository.findAllByRegId(regId);
            List<AttendanceDto> attendanceDtoListByRegId = new ArrayList<>();

            if(listOfAttendanceByRegIdIterable != null) {

                for(AttendanceDomain oneObjAttendanceDomain: listOfAttendanceByRegIdIterable){
                    AttendanceDto attendanceDto = convertAttendanceDomainToDto(oneObjAttendanceDomain);

                    attendanceDtoListByRegId.add(attendanceDto);
                }

                responseDto.setStatus(true);
                responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
                responseDto.setData(attendanceDtoListByRegId);
                return responseDto;

            } else {

                responseDto.setStatus(false);
                responseDto.setStatusMessage(StatusMessages.ENTRY_DOESNOT_EXIST.getStatusMessage());
                return responseDto;
            }


        } else {

            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());

            return responseDto;
        }
//        return null;
    }

    private AttendanceDto convertAttendanceDomainToDto(AttendanceDomain oneObjAttendanceDomain) {
        AttendanceDto attendanceDto = new AttendanceDto();

        attendanceDto.setDate(oneObjAttendanceDomain.getDate());
        attendanceDto.setAddedAdminRegId(oneObjAttendanceDomain.getAddedAdminRegId().getId());
        attendanceDto.setId(oneObjAttendanceDomain.getId());

        return attendanceDto;
    }


    private AttendanceDomain convertAttendanceDtoToDomain(AttendanceDto attendanceDto) {
        AttendanceDomain attendanceDomain = new AttendanceDomain();

        attendanceDomain.setDate(attendanceDto.getDate());
        attendanceDomain.setAddedAdminRegId(attendanceDomain.getAddedAdminRegId());

        for(Long oneId: attendanceDto.getAttendantPlayerIds()){

        }

        return attendanceDomain;
    }
}
