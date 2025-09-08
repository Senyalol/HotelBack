package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    public Booking findById(int id);
    List<Booking> findByUserId(int userId);
    List<Booking> findByRoomId(int roomId);

}
