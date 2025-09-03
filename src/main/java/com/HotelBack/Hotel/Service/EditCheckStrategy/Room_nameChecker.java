package com.HotelBack.Hotel.Service.EditCheckStrategy;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;

public class Room_nameChecker implements EditCheck {


    @Override
    public void check(RoomDTO roomDTO, Room room) {

        if(roomDTO != null){

            if(roomDTO.getRoomName() != null){

                room.setRoomName(roomDTO.getRoomName());

            }

        }

    }

}
