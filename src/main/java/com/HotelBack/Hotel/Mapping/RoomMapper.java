package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class RoomMapper {

    //Из сущности в DTO
    public RoomDTO EntityToDTO(Room entity) {

        RoomDTO dto = new RoomDTO();

        dto.setRoomName(entity.getRoomName());
        dto.setPrice(entity.getPrice());
        dto.setBedType(entity.getBedType());
        dto.setArea(entity.getArea());
        dto.setCapacity(entity.getCapacity());
        dto.setView(entity.getView());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());

        return dto;

    }

    //Из DTO в сущность
    public Room DTOToEntity(RoomDTO dto) {

        Room entity = new Room();

        entity.setRoomName(dto.getRoomName());
        entity.setPrice(dto.getPrice());
        entity.setBedType(dto.getBedType());
        entity.setArea(dto.getArea());
        entity.setCapacity(dto.getCapacity());
        entity.setView(dto.getView());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());

        return entity;
    }

}
