package com.HotelBack.Hotel.Service.RoomService.EditRoomChecks;

import com.HotelBack.Hotel.Entity.Room;
import lombok.Data;

import java.util.List;

@Data
public class RoomChecker {

    private List<EditRoomCheck> checks;

    public RoomChecker(List<EditRoomCheck> checks) {
        this.checks = checks;
    }


    public void check(Room updateRoom, Room room) {

        for (EditRoomCheck checker : checks) {

            checker.check(updateRoom, room);

        }

    }

}
