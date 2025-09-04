package com.HotelBack.Hotel.Service.EditCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class DescriptionChecker implements EditRoomCheck {
    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getDescription() != null){
                room.setDescription(roomDTO.getDescription());
            }

        }

    }
}
