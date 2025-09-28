package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.RoomDTO;
import com.HotelBack.Hotel.Facade.RoomFacade.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomFacade roomFacade;

    @Autowired
    public RoomController(RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }

    //Получить все номера
    //Адрес http://localhost:8080/api/rooms
    //@PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping
    public List<RoomDTO> getAllRooms() {

        return roomFacade.findAllRooms();

    }

    //Создать новый номер
    //Адрес http://localhost:8080/api/rooms
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {

        return roomFacade.save(roomDTO);

    }

    //Обновить данные о номере по id
    //Адрес http://localhost:8080/api/rooms/update/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public RoomDTO updateRoom(@PathVariable int id, @RequestBody RoomDTO roomDTO) {
        return roomFacade.editRoom(id, roomDTO);
    }

    //Удалить номер по id
    //Адрес http://localhost:8080/api/rooms/delete/id
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomFacade.deleteRoom(id);
    }

}