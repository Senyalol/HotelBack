package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;

public class Room_nameChecker implements EditRoomCheck {


    @Override
    public void check(Room updateRoom, Room room) {

        if(updateRoom != null){

            if(updateRoom.getRoomName() != null){

                room.setRoomName(updateRoom.getRoomName());

            }

        }

    }

}
