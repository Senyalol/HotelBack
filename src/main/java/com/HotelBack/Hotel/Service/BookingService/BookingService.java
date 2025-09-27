package com.HotelBack.Hotel.Service.BookingService;

import com.HotelBack.Hotel.DTO.BookingDTO;
import com.HotelBack.Hotel.Entity.Booking;
import com.HotelBack.Hotel.Mapping.BookingMapper;
import com.HotelBack.Hotel.Repository.BookingRepository;
import com.HotelBack.Hotel.Repository.RoomRepository;
import com.HotelBack.Hotel.Repository.UserRepository;
import com.HotelBack.Hotel.Service.BookingService.CreateBookingChecks.*;
import com.HotelBack.Hotel.Service.BookingService.EditBookingChecks.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@JsonSerialize
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository
                        , BookingMapper bookingMapper
                        , UserRepository userRepository
                        , RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }



    //Просмотр всех броней
    public List<BookingDTO> getAllBookings() {

        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream()
                .map(booking -> bookingMapper.EntityToDTO(booking))
                .collect(Collectors.toList());

    }

    //Удалить по id бронь
    public void deleteBooking(int id){

        bookingRepository.deleteById(id);

    }

    //Сделать бронь
    public BookingDTO createBooking(BookingDTO bookingDTO){

        List<CreateBookingCheck> checks = Arrays.asList(
                new userIdCreateChecker(userRepository),
                new roomIdCreateChecker(roomRepository),
                new startDateCreateChecker(),
                new endDateCreateChecker(),
                new statusCreateCheck()
        );

        BookingCreateChecker bookingCreateChecker = new BookingCreateChecker(checks);

        if(bookingDTO != null && bookingCreateChecker.check(bookingDTO)){

            try{

                Booking savedBooking = bookingMapper.DTOToEntity(bookingDTO);
                bookingRepository.save(savedBooking);
                return bookingDTO;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        throw new ValidationException("Данные бронирования невалидны");

    }

    //Редактировать бронь
    public BookingDTO updateBooking(int id, BookingDTO bookingDTO){


        Booking editableBooking = bookingRepository.findById(id);

        if(bookingDTO != null){

            try{

                List<EditBookingCheck> checks = Arrays.asList(
                        new userIdChecker(userRepository),
                        new roomIdChecker(roomRepository),
                        new startDateChecker(),
                        new endDateChecker(),
                        new statusChecker()
                );

                BookingChecker bookingChecker = new BookingChecker(checks);

                bookingChecker.check(bookingDTO, editableBooking);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        return bookingMapper.EntityToDTO(bookingRepository.findById(id));

    }

}
