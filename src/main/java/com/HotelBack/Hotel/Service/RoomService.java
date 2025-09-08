package com.HotelBack.Hotel.Service;

//import com.HotelBack.Hotel.Entity.Room;
import com.HotelBack.Hotel.DTO.RoomDTO;
//import com.HotelBack.Hotel.DTO.UserDTO;
import com.HotelBack.Hotel.Entity.Room;
import com.HotelBack.Hotel.Mapping.RoomMapper;
import com.HotelBack.Hotel.Repository.BookingRepository;
import com.HotelBack.Hotel.Repository.RoomRepository;
import com.HotelBack.Hotel.Service.CreateCheckStrategy.Room.*;
import com.HotelBack.Hotel.Service.EditCheckStrategy.Room.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@Transactional
@JsonSerialize
public class RoomService {

 private final RoomRepository roomRepository;
 private final RoomMapper roomMapper;
 private final BookingRepository bookingRepository;

 @Autowired
 public RoomService(RoomRepository roomRepository, RoomMapper roomMapper,BookingRepository bookingRepository) {
  this.roomRepository = roomRepository;
  this.roomMapper = roomMapper;
  this.bookingRepository = bookingRepository;
 }

 //Метод для добавления комнаты в БД
 public RoomDTO save(RoomDTO roomDTO) {

     List<CreateRoomCheck> checks = Arrays.asList(
             new roomNameCreateChecker(), new priceCreateChecker(),
             new bedTypeCreateChecker(), new areaCreateChecker(),
             new capacityCreateChecker(), new viewCreateChecker(),
             new descriptionCreateChecker()
     );

     RoomCreateChecker checker = new RoomCreateChecker(checks);

   if(roomDTO != null && checker.check(roomDTO)) {

    try{

        if(roomDTO.getStatus() == null){
            roomDTO.setStatus(RoomStatus.свободен.toString());
        }


      roomRepository.save(roomMapper.DTOToEntity(roomDTO));
      return roomDTO;
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }

   }

  return null;
 }

 //Метод для просмотра всех комнат БД
 public List<RoomDTO> findAllRooms() {

  List<Room> rooms = roomRepository.findAll();
         return rooms.stream()
                 .map(room -> roomMapper.EntityToDTO(room))
                 .collect(Collectors.toList());

 }

 //Метод для удаления комнаты из БД
 public void deleteRoom(int id){

        bookingRepository.deleteAllByRoomId(id);
        roomRepository.deleteById(id);
 }

 //Метод для редактирования комнаты в БД
 public RoomDTO editRoom(int id, RoomDTO roomDTO) {

    Room editableroom = roomRepository.findById(id);

    List<EditRoomCheck> checks = Arrays.asList(new Room_nameChecker()
                                           ,new PriceChecker()
                                           , new BedTypeChecker()
                                           ,new AreaChecker()
                                           ,new CapacityChecker()
                                           , new ViewChecker()
                                           ,new DescriptionChecker()
                                           , new StatusChecker());

    RoomChecker checker = new RoomChecker(checks);

    try{

        checker.check(roomDTO,editableroom);

    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return roomMapper.EntityToDTO(roomRepository.findById(id));

 }

}
