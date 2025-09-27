package com.HotelBack.Hotel.Service.BookingService.EditBookingChecks;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;

public class endDateChecker implements EditBookingCheck{
    @Override
    public void check(BookingDTO bookingDTO, Booking booking) {

        if(bookingDTO != null && bookingDTO.getEndDate() != null){

            booking.setEndDate(bookingDTO.getEndDate());

        }

    }
}
