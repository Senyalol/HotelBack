package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;

public class statusChecker implements EditBookingCheck{
    @Override
    public void check(Booking updateBooking, Booking booking) {

        if(updateBooking != null && updateBooking.getStatus() != null){

            booking.setStatus(updateBooking.getStatus());

        }

    }
}
