package com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;

public class startDateCreateChecker implements CreateBookingCheck{
    @Override
    public boolean check(Booking booking) {

        boolean result = true;

        if(booking == null || booking.getStartDate() == null){
         result = false;
        }

        return result;
    }
}