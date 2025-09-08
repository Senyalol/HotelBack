package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    User findByEmail(String email);
    void deleteUserByEmail(String email);

}
