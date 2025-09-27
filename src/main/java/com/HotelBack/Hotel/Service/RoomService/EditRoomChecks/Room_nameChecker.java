package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class Room_nameChecker implements EditRoomCheck {


    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getRoomName() != null){

                room.setRoomName(roomDTO.getRoomName());

            }

        }

    }

}
