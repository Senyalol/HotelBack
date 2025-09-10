package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    //Получить все номера
    //Адрес http://localhost:8080/api/rooms
    @GetMapping
    public List<RoomDTO> getAllRooms() {

        return roomService.findAllRooms();

    }

    //Создать новый номер
    //Адрес http://localhost:8080/api/rooms
    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {

        return roomService.save(roomDTO);

    }

    //Обновить данные о номере по id
    //Адрес http://localhost:8080/api/rooms/update/id
    @PatchMapping("/update/{id}")
    public RoomDTO updateRoom(@PathVariable int id, @RequestBody RoomDTO roomDTO) {
        return roomService.editRoom(id, roomDTO);
    }

    //Удалить номер по id
    //Адрес http://localhost:8080/api/rooms/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomService.deleteRoom(id);
    }

}
