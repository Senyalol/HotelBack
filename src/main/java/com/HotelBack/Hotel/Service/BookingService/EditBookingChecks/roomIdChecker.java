package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdChecker implements EditBookingCheck{

    private final RoomRepository roomRepository;

    public roomIdChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void check(Booking updateBooking, Booking booking) {

        if(updateBooking != null && updateBooking.getRoom().getId() != null) {

            int roomId = updateBooking.getRoom().getId();

            booking.setUser(updateBooking.getUser());
            booking.setRoom(roomRepository.findById(roomId));

        }

    }
}
