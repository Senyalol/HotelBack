package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;

public class endDateCreateChecker implements CreateBookingCheck{
    @Override
    public boolean check(BookingDTO bookingDTO) {

        boolean result = true;

        if(bookingDTO == null || bookingDTO.getEndDate() == null){
            result = false;
        }

        return result;
    }
}
