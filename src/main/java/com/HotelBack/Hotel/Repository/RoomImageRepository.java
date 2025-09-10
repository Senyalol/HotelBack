package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomImageRepository extends JpaRepository<RoomImage, Integer> {

    List<RoomImage> findByRoomId(int roomId);
    RoomImage findById(int id);

}
