package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;

public class startDateCreateChecker implements CreateBookingCheck{
    @Override
    public boolean check(BookingDTO bookingDTO) {

        boolean result = true;

        if(bookingDTO == null || bookingDTO.getStartDate() == null){
         result = false;
        }

        return result;
    }
}
