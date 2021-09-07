package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.Faculty;
import com.example.badminton2021be.badminton_backend_2021.domain.University;
import com.example.badminton2021be.badminton_backend_2021.dto.FacultyDto;
import com.example.badminton2021be.badminton_backend_2021.dto.UniversityDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.UniversityRepository;
import com.example.badminton2021be.badminton_backend_2021.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;


    @Override
    public ResponseDto getAllActive() {
        ResponseDto responseDto = new ResponseDto();

        List<University> universityList = universityRepository.getAllActive();
        List<UniversityDto> universityDtoList = new ArrayList<UniversityDto>();

        for(University university: universityList) {
            UniversityDto universityDto = convertUniversityDomainToDto(university);
            universityDtoList.add(universityDto);
        }
        if(!universityDtoList.isEmpty()) {
            responseDto.setData(universityDtoList);
            responseDto.setStatus(true);
            responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
        } else {
            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
        }
        return responseDto;
    }

    private UniversityDto convertUniversityDomainToDto(University university) {
        UniversityDto universityDto = new UniversityDto();

        universityDto.setUniversity(university.getUniversity());
        universityDto.setDeleted(university.getDeleted());
        universityDto.setId(university.getId());

        return universityDto;
    }
}
