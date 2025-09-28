package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.Entity.Booking;

public class endDateChecker implements EditBookingCheck{
    @Override
    public void check(Booking updateBooking, Booking booking) {

        if(updateBooking != null && updateBooking.getEndDate() != null){


            booking.setEndDate(updateBooking.getEndDate());

        }

    }
}
