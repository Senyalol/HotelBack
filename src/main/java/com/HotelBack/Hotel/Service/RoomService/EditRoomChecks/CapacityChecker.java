package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class CapacityChecker implements EditRoomCheck {

    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getCapacity() != null){
                room.setCapacity(roomDTO.getCapacity());
            }

        }

    }

}
