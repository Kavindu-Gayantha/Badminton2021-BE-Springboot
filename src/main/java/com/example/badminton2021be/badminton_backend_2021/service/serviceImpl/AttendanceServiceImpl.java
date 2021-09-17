package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.AttendanceDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.AttendanceRepository;
import com.example.badminton2021be.badminton_backend_2021.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private AttendanceDomain convertAttendanceDtoToDomain(AttendanceDto attendanceDto) {
        AttendanceDomain attendanceDomain = new AttendanceDomain();

        attendanceDomain.setDate(attendanceDto.getDate());
        attendanceDomain.setAddedAdminRegId(attendanceDomain.getAddedAdminRegId());

        for(Long oneId: attendanceDto.getAttendantPlayerIds()){

        }

        return attendanceDomain;
    }
}
