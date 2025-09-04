package com.HotelBack.Hotel.Service.CreateCheckStrategy.Room;

import com.HotelBack.Hotel.DTO.RoomDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomCreateChecker {

    private final List<CreateRoomCheck> checks;

    public RoomCreateChecker(List<CreateRoomCheck> checks) {
        this.checks = checks;
    }

    public boolean check(RoomDTO roomDTO) {

        boolean result = true;
        for(CreateRoomCheck check : checks){

            if(!check.check(roomDTO)){
                result = false;
            }

        }

        return result;
    }

}
