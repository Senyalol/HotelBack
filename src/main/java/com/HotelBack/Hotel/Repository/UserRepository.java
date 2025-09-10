package com.HotelBack.Hotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HotelBack.Hotel.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);
    User findByEmail(String email);
    void deleteUserByEmail(String email);

}
