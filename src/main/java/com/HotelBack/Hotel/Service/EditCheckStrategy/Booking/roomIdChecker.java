package com.HotelBack.Hotel.Service.EditCheckStrategy.Booking;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdChecker implements EditBookingCheck{

    private final RoomRepository roomRepository;

    public roomIdChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void check(BookingDTO bookingDTO, Booking booking) {

        if(bookingDTO != null && bookingDTO.getRoom_id() != null) {

            int roomId = bookingDTO.getRoom_id();

            booking.setRoom(roomRepository.findById(roomId));


        }

    }
}
