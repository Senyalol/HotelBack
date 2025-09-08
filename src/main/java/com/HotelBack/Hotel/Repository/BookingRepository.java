package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    public Booking findById(int id);
    List<Booking> findAllBookingByUserId(int userId);
    List<Booking> findAllBookingByRoomId(int roomId);
    void deleteAllByUserId(int userId);
    void deleteAllByRoomId(int roomId);

}
