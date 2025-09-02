package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

    public Room findById(int id);

}
