package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Repository.RoomRepository;

public class roomIdCreateChecker implements CreateBookingCheck{

    private final RoomRepository roomRepository;

    public roomIdCreateChecker(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public boolean check(BookingDTO bookingDTO) {

        boolean result = true;

        if(bookingDTO == null || bookingDTO.getRoom_id() == null || roomRepository.findById(bookingDTO.getRoom_id()).isEmpty()){
            result = false;
        }

        return result;
    }
}
