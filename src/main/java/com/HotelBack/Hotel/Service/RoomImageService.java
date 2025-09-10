package com.HotelBack.Hotel.Service;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;
import com.HotelBack.Hotel.Mapping.RoomImageMapper;
import com.HotelBack.Hotel.Repository.RoomImageRepository;
import com.HotelBack.Hotel.Repository.RoomRepository;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage.CreateRoomImageCheck;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage.RoomImageCreateChecker;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage.imageCreateChecker;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage.roomIdCreateChecker;
import com.HotelBack.Hotel.Service.EditCheckStrategy.RoomImage.EditRoomImageCheck;
import com.HotelBack.Hotel.Service.EditCheckStrategy.RoomImage.RoomImageChecker;
import com.HotelBack.Hotel.Service.EditCheckStrategy.RoomImage.imageChecker;
import com.HotelBack.Hotel.Service.EditCheckStrategy.RoomImage.roomIdChecker;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Transactional
@JsonSerialize
public class RoomImageService {

    private final RoomImageRepository roomImageRepository;
    private final RoomImageMapper roomImageMapper;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomImageService(RoomImageRepository roomImageRepository, RoomImageMapper roomImageMapper, RoomRepository roomRepository) {
        this.roomImageRepository = roomImageRepository;
        this.roomImageMapper = roomImageMapper;
        this.roomRepository = roomRepository;
    }

    public List<RoomImageDTO> getAllImages(){

        List<RoomImage> images = roomImageRepository.findAll();

        return images.stream()
                .map(image -> roomImageMapper.EntityToDTO(image))
                .collect(Collectors.toList());

    }

    public List<RoomImageDTO> getAllImagesFromRoom(int roomId){

        List<RoomImage> images = roomImageRepository.findByRoomId(roomId);

        return images.stream()
                .map(image-> roomImageMapper.EntityToDTO(image))
                .collect(Collectors.toList());

    }

    public RoomImageDTO createImage(RoomImageDTO imageDTO){

        List<CreateRoomImageCheck> checks = Arrays.asList(
          new roomIdCreateChecker(roomRepository),
          new imageCreateChecker()
        );

        RoomImageCreateChecker checker = new RoomImageCreateChecker(checks);

        if(checker.check(imageDTO)){

            roomImageRepository.save(roomImageMapper.DTOToEntity(imageDTO));
            return imageDTO;
        }

        return null;

    }

    public void deleteImageById(int id){
        roomImageRepository.deleteById(id);
    }

    public RoomImageDTO editImage(int id, RoomImageDTO imageDTO){

        List<EditRoomImageCheck> checks = Arrays.asList(
                new roomIdChecker(roomRepository),
                new imageChecker()
        );

        RoomImageChecker checker = new RoomImageChecker(checks);

        if(imageDTO != null){

            RoomImage roomImage = roomImageRepository.findById(id);
            checker.check(imageDTO, roomImage);

        }

        return roomImageMapper.EntityToDTO(roomImageRepository.findById(id));

    }

}
