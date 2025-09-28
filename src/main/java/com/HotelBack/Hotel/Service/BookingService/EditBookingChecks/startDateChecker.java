package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;

public class startDateChecker implements EditBookingCheck{
    @Override
    public void check(Booking updateBooking, Booking booking) {

        if(updateBooking != null && updateBooking.getStartDate() != null){

            booking.setStartDate(updateBooking.getStartDate());

        }

    }
}
