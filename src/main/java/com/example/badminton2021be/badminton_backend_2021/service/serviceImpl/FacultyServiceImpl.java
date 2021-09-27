package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Faculty;
import com.example.badminton2021be.badminton_backend_2021.dto.FacultyDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.FacultyRepository;
import com.example.badminton2021be.badminton_backend_2021.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public ResponseDto getAllActive(Long loginUserUniId) {
        ResponseDto responseDto = new ResponseDto();

        List<Faculty> facultyList = facultyRepository.getAllActiveByTokenUniId(loginUserUniId);
        List<FacultyDto> facultyDtoList = new ArrayList<FacultyDto>();

        for(Faculty faculty: facultyList) {
            FacultyDto facultyDto = convertFacultyDomainToDto(faculty);
            facultyDtoList.add(facultyDto);
        }
        if(!facultyDtoList.isEmpty()) {
            responseDto.setData(facultyDtoList);
            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
        } else {
            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
        }
        return responseDto;

    }

    private FacultyDto convertFacultyDomainToDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();

        facultyDto.setFaculty(faculty.getFacultyName());
        facultyDto.setDeleted(faculty.getDeleted());
        facultyDto.setId(faculty.getId());

        return facultyDto;
    }
}
