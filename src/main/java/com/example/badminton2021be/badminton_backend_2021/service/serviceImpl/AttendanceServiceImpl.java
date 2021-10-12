package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.AttendanceDomain;
import com.example.badminton2021be.badminton_backend_2021.domain.Players;
import com.example.badminton2021be.badminton_backend_2021.domain.RegisterDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.AttendanceDto;
import com.example.badminton2021be.badminton_backend_2021.dto.PlayersDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.AttendanceRepository;
import com.example.badminton2021be.badminton_backend_2021.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public ResponseDto attendanceMarking(AttendanceDto attendanceDto) {
        ResponseDto responseDto = new ResponseDto();

        if (attendanceDto != null) {
//            AttendanceDomain convertedAttendantPlayerData = convertAttendanceDtoToDomain(attendanceDto);
            //TODO - check the date is already is given


            for (int i = 0; i < attendanceDto.getAttendantPlayerIds().length; i++) {
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
    public ResponseDto getIndividualAttendanceDetailsByRegId(Long regId, Long uniId) {
        ResponseDto responseDto = new ResponseDto();
        Long count = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fromDate = dateFormat.parse("2021-08-01");
//        Date toDate = dateFormat.parse("2021-08-08");

        if (regId != null) {
            //GET ALL THE DATES INDIVIDUAL ATTENDED
            Iterable<AttendanceDomain> listOfAttendanceByRegIdIterable = attendanceRepository.findAllByRegId(regId);
            List<AttendanceDomain> attendaceDataWithinThisMonth = attendanceRepository.findDatesCountOfAllTime(regId);
            List<Date> allPractiseDataAllTheTime= attendanceRepository.findDatesCountOfAllTimeByAddedAdmin(uniId);

            List<AttendanceDto> attendanceDtoListByRegId = new ArrayList<>();

            if (listOfAttendanceByRegIdIterable != null) {

//                for (AttendanceDomain oneObjAttendanceDomain : listOfAttendanceByRegIdIterable) {
//                    AttendanceDto attendanceDto = convertAttendanceDomainToDto(oneObjAttendanceDomain);
//
//                    attendanceDtoListByRegId.add(attendanceDto);
//                    count = count + 1;
//                }
                AttendanceDto attendanceDto2 = new AttendanceDto();
                attendanceDto2.setAttendanceAllMonthCount(count);
                attendanceDto2.setAttendanceAllMonthCount(attendaceDataWithinThisMonth.stream().count());
                attendanceDto2.setPractiseHeldDaysAllMonthCount(allPractiseDataAllTheTime.stream().count());
                attendanceDtoListByRegId.add(attendanceDto2);

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

    @Override
    public ResponseDto getAllAttendanceByUniId(Long uniId) {
        ResponseDto responseDto = new ResponseDto();

        if(uniId != null) {

            List<AttendanceDomain> attendanceDomainList = attendanceRepository.getAttendanceByUniId(uniId);
            List<AttendanceDto> attendanceDtoList = new ArrayList<AttendanceDto>();

            for(AttendanceDomain oneRowDataDomain: attendanceDomainList){
                AttendanceDto convertedAttendanceToDto = convertAttendanceDomainToDto(oneRowDataDomain);
                attendanceDtoList.add(convertedAttendanceToDto);
            }

            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
            responseDto.setData(attendanceDtoList);
            return responseDto;

        } else {

            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
return responseDto;

        }

    }

    private AttendanceDto convertAttendanceDomainToDto(AttendanceDomain oneObjAttendanceDomain) {
        AttendanceDto attendanceDto = new AttendanceDto();

        attendanceDto.setDate(oneObjAttendanceDomain.getDate());
        attendanceDto.setAddedAdminRegId(oneObjAttendanceDomain.getAddedAdminRegId().getId());
        attendanceDto.setId(oneObjAttendanceDomain.getId());

        PlayersDto playersDto = new PlayersDto();
        playersDto.setId(oneObjAttendanceDomain.getAttendantPlayer().getId());
        playersDto.setEmail(oneObjAttendanceDomain.getAttendantPlayer().getEmail());
        playersDto.setName(oneObjAttendanceDomain.getAttendantPlayer().getName());
        attendanceDto.setPlayersDto(playersDto);

        return attendanceDto;
    }


    private AttendanceDomain convertAttendanceDtoToDomain(AttendanceDto attendanceDto) {
        AttendanceDomain attendanceDomain = new AttendanceDomain();

        attendanceDomain.setDate(attendanceDto.getDate());
        attendanceDomain.setAddedAdminRegId(attendanceDomain.getAddedAdminRegId());

        for (Long oneId : attendanceDto.getAttendantPlayerIds()) {

        }

        return attendanceDomain;
    }
}
