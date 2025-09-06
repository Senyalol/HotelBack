package com.HotelBack.Hotel.Repository;

import com.HotelBack.Hotel.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    UserRole findByRole(String role);
    UserRole findByUserId(Integer userId);
    UserRole findById(int id);
}