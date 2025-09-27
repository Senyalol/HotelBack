package com.HotelBack.Hotel.Service.RoomService;

import com.HotelBack.Hotel.Entity.Room;

import java.util.List;

public interface RoomService {

    //Метод для добавления комнаты в БД
    Room save(Room room);

    //Метод для просмотра всех комнат БД
    List<Room> findAllRooms();

    //Метод для удаления комнаты из БД
    void deleteRoom(int id);

    //Метод для редактирования комнаты в БД
    Room editRoom(int id, Room room);

}
