package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdCreateChecker implements CreateBookingCheck{

    private final RoomRepository roomRepository;

    public roomIdCreateChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean check(Booking booking) {

        boolean result = true;

        if(booking == null || booking.getRoom().getId() == null
                || roomRepository.findById(booking.getRoom().getId()).isEmpty()){

            result = false;

        }

        return result;
    }
}
