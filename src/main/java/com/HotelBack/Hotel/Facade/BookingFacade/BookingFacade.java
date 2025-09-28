package com.HotelBack.Hotel.Facade.BookingFacade;

import com.HotelBack.Hotel.DTO.BookingDTO;

import java.util.List;

public interface BookingFacade {

    List<BookingDTO> getAllBookings();

    void deleteBooking(int id);

    BookingDTO createBooking(BookingDTO booking);

    BookingDTO updateBooking(int id, BookingDTO booking);


}
