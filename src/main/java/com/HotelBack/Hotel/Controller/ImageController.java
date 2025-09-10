package com.HotelBack.Hotel.Controller;

import com.HotelBack.Hotel.DTO.RoomImageDTO;
import com.HotelBack.Hotel.Service.RoomImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5174"})
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final RoomImageService roomImageService;

    @Autowired
    public ImageController(RoomImageService roomImageService) {
        this.roomImageService = roomImageService;
    }

    //Получить список вообще всех фоторграфий
    //Адрес - http://localhost:8080/api/images
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping
    public List<RoomImageDTO> getAllImages() {
        return roomImageService.getAllImages();
    }

    //Получить все фотографии конкретной комнаты
    //Адрес - http://localhost:8080/api/images/{id}
    @PreAuthorize("hasAuthority('ADMIN') || hasAuthority('USER')")
    @GetMapping("/{id}")
    public List<RoomImageDTO> getRoomImages(@PathVariable int id) {
        return roomImageService.getAllImagesFromRoom(id);
    }

    //Добавить фотографию комнаты
    //Адрес - http://localhost:8080/api/images
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public RoomImageDTO addImage(@RequestBody RoomImageDTO roomImageDTO) {
        return roomImageService.createImage(roomImageDTO);
    }

    //Удалить фотографию комнаты
    //Адрес - http://localhost:8080/api/images/delete/{id}
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void deleteImage(@PathVariable int id) {
        roomImageService.deleteImageById(id);
    }

    //Редактировать фотографию комнаты
    //Адрес http://localhost:8080/api/images/update/{id}
    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{id}")
    public RoomImageDTO updateImage(@PathVariable int id, @RequestBody RoomImageDTO roomImageDTO) {
        return roomImageService.editImage(id, roomImageDTO);
    }

}
