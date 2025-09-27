package com.HotelBack.Hotel.Service.RoomService;

import com.HotelBack.Hotel.Entity.Room;
import com.HotelBack.Hotel.Repository.RoomRepository;
import com.HotelBack.Hotel.Service.RoomService.CreateRoomChecks.*;
import com.HotelBack.Hotel.Service.RoomService.EditRoomChecks.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Data
@Service
@Transactional
@JsonSerialize
public class RoomServiceImpl implements RoomService {

 private final RoomRepository roomRepository;

 @Autowired
 public RoomServiceImpl(RoomRepository roomRepository) {
  this.roomRepository = roomRepository;
 }

 //Метод для добавления комнаты в БД
 public Room save(Room room) {

     List<CreateRoomCheck> checks = Arrays.asList(
             new roomNameCreateChecker(), new priceCreateChecker(),
             new bedTypeCreateChecker(), new areaCreateChecker(),
             new capacityCreateChecker(), new viewCreateChecker(),
             new descriptionCreateChecker(), new amenitiesCreateChecker()
     );

     RoomCreateChecker checker = new RoomCreateChecker(checks);

   if(room != null && checker.check(room)) {

    try{

        if(room.getStatus() == null){
            room.setStatus(RoomStatus.свободен.toString());
        }

      roomRepository.save(room);
      return room;
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }

   }

  return null;
 }

 //Метод для просмотра всех комнат БД
 public List<Room> findAllRooms() {

  return roomRepository.findAll();

 }

 //Метод для удаления комнаты из БД
 public void deleteRoom(int id){
     roomRepository.deleteById(id);
 }

 //Метод для редактирования комнаты в БД
 public Room editRoom(int id, Room room) {

    Room editableroom = roomRepository.findById(id);

    List<EditRoomCheck> checks = Arrays.asList(new Room_nameChecker()
                                           ,new PriceChecker()
                                           , new BedTypeChecker()
                                           ,new AreaChecker()
                                           ,new CapacityChecker()
                                           , new ViewChecker()
                                           ,new DescriptionChecker()
                                           , new StatusChecker()
                                           , new AmenitiesChecker()
    );

    RoomChecker checker = new RoomChecker(checks);

    try{

        checker.check(room,editableroom);

    }
    catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return roomRepository.findById(id);

 }

}
