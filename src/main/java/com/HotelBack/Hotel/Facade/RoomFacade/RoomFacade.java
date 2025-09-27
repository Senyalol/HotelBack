package com.HotelBack.Hotel.Facade.RoomFacade;

import com.HotelBack.Hotel.DTO.RoomDTO;

import java.util.List;

public interface RoomFacade {

    RoomDTO save(RoomDTO room);

    //Метод для просмотра всех комнат БД
    List<RoomDTO> findAllRooms();

    //Метод для удаления комнаты из БД
    void deleteRoom(int id);

    //Метод для редактирования комнаты в БД
    RoomDTO editRoom(int id, RoomDTO room);

}
