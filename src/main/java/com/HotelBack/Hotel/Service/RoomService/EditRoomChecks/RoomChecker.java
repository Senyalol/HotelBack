package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;
import lombok.Data;

import java.util.List;

@Data
public class RoomChecker {

    private List<EditRoomCheck> checks;

    public RoomChecker(List<EditRoomCheck> checks) {
        this.checks = checks;
    }


    public void check(RoomDTO roomDTO, Room room) {

        for (EditRoomCheck checker : checks) {

            checker.check(roomDTO, room);

        }

    }

}
