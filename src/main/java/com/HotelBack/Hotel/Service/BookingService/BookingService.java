package com.HotelBack.Hotel.Service.BookingService;

import com.HotelBack.Hotel.Entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBookings();

    void deleteBooking(int id);

    Booking createBooking(Booking booking);

    Booking updateBooking(int id, Booking booking);

    Booking getBookingById(int id);

}
