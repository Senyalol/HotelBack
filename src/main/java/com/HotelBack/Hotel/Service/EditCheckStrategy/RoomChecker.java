package com.HotelBack.Hotel.Service.EditCheckStrategy;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Entity.Room;
import lombok.Data;

import java.util.List;

@Data
public class RoomChecker {

    private List<EditCheck> checks;

    public RoomChecker(List<EditCheck> checks) {
        this.checks = checks;
    }


    public void check(RoomDTO roomDTO, Room room) {

        for (EditCheck checker : checks) {

            checker.check(roomDTO, room);

        }

    }

}
