package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.domain.VideoDomain;
import com.example.badminton2021be.badminton_backend_2021.dto.VideoDto;
import com.example.badminton2021be.badminton_backend_2021.dto.common_module.ResponseDto;
import com.example.badminton2021be.badminton_backend_2021.enumuration.StatusMessages;
import com.example.badminton2021be.badminton_backend_2021.repository.VideoRepository;
import com.example.badminton2021be.badminton_backend_2021.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoRepository videoRepository;

    @Override
    public ResponseDto getAllVideoLinks() {
        ResponseDto responseDto = new ResponseDto();
        List<VideoDomain> getAllVideoLinks = videoRepository.findAllLinks();
        List<VideoDto> videoDtoList = new ArrayList<VideoDto>();

        for(VideoDomain oneVideoDomain: getAllVideoLinks){
            VideoDto videoDto = convertVideoDomainToDto(oneVideoDomain);
            videoDtoList.add(videoDto);
        }
        responseDto.setStatusMessage(StatusMessages.SUCCESSFULLY_GET.getStatusMessage());
        responseDto.setStatus(true);
        responseDto.setData(videoDtoList);
        return responseDto;
    }

    @Override
    public ResponseDto createVideoLink(VideoDto videoDto) {
        ResponseDto responseDto = new ResponseDto();

        if(videoDto != null){
            VideoDomain convertedVideObj = convertVideoDtoToDomain(videoDto);
            convertedVideObj = videoRepository.save(convertedVideObj);

            responseDto.setData(convertedVideObj);
            responseDto.setStatusMessage(StatusMessages.ADDED_SUCCESSFULLY.getStatusMessage());
            responseDto.setStatus(true);
            return responseDto;

        } else {
            responseDto.setStatus(false);
            responseDto.setStatusMessage(StatusMessages.PLEASE_PROVIDE_REQUIRED_DATA.getStatusMessage());
            return responseDto;
        }
//        return null;
    }

    private VideoDomain convertVideoDtoToDomain(VideoDto videoDto) {
        VideoDomain videoDomain = new VideoDomain();

        videoDomain.setYoutubeLink(videoDto.getYoutubeLink());
        return videoDomain;
    }

    private String getYoutubeIdFromYoutubeLink(String fullURL){

        String videoId = fullURL.substring(17);
        return videoId;
    }

    private VideoDto convertVideoDomainToDto(VideoDomain oneVideoDomain) {
        VideoDto videoDto = new VideoDto();
        videoDto.setId(oneVideoDomain.getId());

//        if(!oneVideoDomain.getYoutubeLink().matches("^\\s*$")){

            String videoId = getYoutubeIdFromYoutubeLink(oneVideoDomain.getYoutubeLink()); // send the full link to get only video id
            videoDto.setYoutubeLink(videoId);
//        }


        return videoDto;
    }
}
