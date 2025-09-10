package com.HotelBack.Hotel.Service.EditCheckStrategy.RoomImage;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Entity.RoomImage;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdChecker implements EditRoomImageCheck{

    private final RoomRepository roomRepository;

    public roomIdChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void check(RoomImageDTO roomImageDTO, RoomImage roomImage) {

        if(roomImageDTO != null && roomImageDTO.getRoomId() == null){

            int roomId = roomImageDTO.getRoomId();

            if(roomRepository.findById(roomId) != null){
                roomImage.setRoom(roomRepository.findById(roomId));
            }


        }

    }
}
