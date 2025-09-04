package com.HotelBack.Hotel.Service.EditCheckStrategy.Booking;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;

public interface EditBookingCheck {

    void check(BookingDTO bookingDTO, Booking booking);

}
