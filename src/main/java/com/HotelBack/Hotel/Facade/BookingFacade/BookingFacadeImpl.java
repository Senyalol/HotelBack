package com.HotelBack.Hotel.Facade.BookingFacade;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Mapping.BookingMapper;
import com.HotelBack.Hotel.Service.BookingService.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingFacadeImpl implements BookingFacade {

    private final BookingMapper bookingMapper;
    private final BookingService bookingService;

    @Autowired
    public BookingFacadeImpl(BookingMapper bookingMapper,BookingService bookingService) {
        this.bookingMapper = bookingMapper;
        this.bookingService = bookingService;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings()
                .stream()
                .map(x-> bookingMapper.EntityToDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(int id) {
        bookingService.deleteBooking(id);
    }

    @Override
    public BookingDTO createBooking(BookingDTO booking) {
        return bookingMapper.EntityToDTO(bookingService.createBooking(bookingMapper.DTOToEntity(booking)));
    }

    @Override
    public BookingDTO updateBooking(int id, BookingDTO booking) {
        BookingDTO bookingDTO = bookingMapper.EntityToDTO(bookingService.getBookingById(id));
        return bookingMapper.EntityToDTO(bookingService.updateBooking(id, bookingMapper.DTOToEntityUpdate(bookingDTO,booking)));
    }

}