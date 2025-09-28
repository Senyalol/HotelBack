package com.HotelBack.Hotel.Service.BookingService;

import com.HotelBack.Hotel.Entity.Booking;
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

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@JsonSerialize
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository
                        , UserRepository userRepository
                        , RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    //Просмотр всех броней
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();

    }

    //Удалить по id бронь
    public void deleteBooking(int id){
        bookingRepository.deleteById(id);
    }

    //Сделать бронь
    public Booking createBooking(Booking updateBooking){

        List<CreateBookingCheck> checks = Arrays.asList(
                new userIdCreateChecker(userRepository),
                new roomIdCreateChecker(roomRepository),
                new startDateCreateChecker(),
                new endDateCreateChecker(),
                new statusCreateCheck()
        );

        BookingCreateChecker bookingCreateChecker = new BookingCreateChecker(checks);

        if(updateBooking != null && bookingCreateChecker.check(updateBooking)){

            try{

                bookingRepository.save(updateBooking);
                return updateBooking;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        throw new ValidationException("Данные бронирования невалидны");

    }

    //Редактировать бронь
    public Booking updateBooking(int id, Booking updateBooking){

        Booking editableBooking = bookingRepository.findById(id);

        if(updateBooking != null){

            try{

                List<EditBookingCheck> checks = Arrays.asList(
                        new userIdChecker(userRepository),
                        new roomIdChecker(roomRepository),
                        new startDateChecker(),
                        new endDateChecker(),
                        new statusChecker()
                );

                BookingChecker bookingChecker = new BookingChecker(checks);

                bookingChecker.check(updateBooking, editableBooking);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        return bookingRepository.findById(id);

    }

    //Получить бронь по id
    public Booking getBookingById(int id){
        return bookingRepository.findById(id);
    }

}
