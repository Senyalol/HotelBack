package com.HotelBack.Hotel.Facade.RoomFacade;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Mapping.RoomMapper;
import com.HotelBack.Hotel.Service.RoomService.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomFacadeImpl implements RoomFacade {

    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomFacadeImpl(RoomService roomService, RoomMapper roomMapper) {
        this.roomService = roomService;
        this.roomMapper = roomMapper;
    }

    @Override
    public void deleteRoom(int id) {
        roomService.deleteRoom(id);
    }

    @Override
    public RoomDTO save(RoomDTO room) {
        return roomMapper.EntityToDTO(roomService.save(roomMapper.DTOToEntity(room)));
    }

    @Override
    public List<RoomDTO> findAllRooms() {
        return roomService.findAllRooms()
                .stream()
                .map(x->roomMapper.EntityToDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO editRoom(int id, RoomDTO room) {
        return roomMapper.EntityToDTO(roomService.editRoom(id, roomMapper.DTOToEntity(room)));
    }

}
