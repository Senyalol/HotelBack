package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;

public class startDateChecker implements EditBookingCheck{
    @Override
    public void check(BookingDTO bookingDTO, Booking booking) {

        if(bookingDTO != null && bookingDTO.getStartDate() != null){

            booking.setStartDate(bookingDTO.getStartDate());

        }

    }
}
