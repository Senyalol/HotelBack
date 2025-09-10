package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;
import com.HotelBack.Hotel.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomImageMapper {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomImageMapper(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //Из сущности в DTO
    public RoomImageDTO EntityToDTO(RoomImage entity) {

        RoomImageDTO dto = new RoomImageDTO();

        dto.setRoomImageId(entity.getId());
        dto.setRoomId(entity.getRoom().getId());
        dto.setImageUrl(entity.getImage());

        return dto;
    }

    //Из DTO в сущность
    public RoomImage DTOToEntity(RoomImageDTO dto) {

        RoomImage entity = new RoomImage();

        int roomId = dto.getRoomId();

        entity.setId(dto.getRoomImageId());
        entity.setRoom(roomRepository.findById(roomId));
        entity.setImage(dto.getImageUrl());

        return entity;

    }

}
