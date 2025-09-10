package com.HotelBack.Hotel.Service.CreateCheckStrategy.RoomImage;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdCreateChecker implements CreateRoomImageCheck{

    private final RoomRepository roomRepository;

    public roomIdCreateChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean check(RoomImageDTO roomImageDTO) {

        boolean result = true;

        if(roomImageDTO == null || roomImageDTO.getRoomId() == null){

            result = false;
        }
        else{

            int roomId = roomImageDTO.getRoomId();
            if(roomRepository.findById(roomId) == null){
                result = false;
            }

        }

        return result;
    }
}
