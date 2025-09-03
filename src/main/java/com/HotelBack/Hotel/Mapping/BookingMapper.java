package com.HotelBack.Hotel.Mapping;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Repository.RoomRepository;
import com.HotelBack.Hotel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingMapper(UserRepository userRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    //Из сущности в DTO
    public BookingDTO EntityToDTO(Booking booking) {

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setBookingId(booking.getId());
        bookingDTO.setUserId(booking.getUser().getId());
        bookingDTO.setRoom_id(booking.getRoom().getId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setStatus(booking.getStatus());

        return bookingDTO;

    }

    //Из DTO в сущность
    public Booking DTOToEntity(BookingDTO bookingDTO) {

        Booking booking = new Booking();

        booking.setId(bookingDTO.getBookingId());
        booking.setUser(userRepository.findById(bookingDTO.getUserId()).get());

        booking.setRoom(roomRepository.findById(bookingDTO.getRoom_id()).get());

        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setStatus(bookingDTO.getStatus());

        return booking;
    }

}
