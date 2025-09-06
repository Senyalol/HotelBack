package com.HotelBack.Hotel.Security;

import com.HotelBack.Hotel.Entity.User;
import com.HotelBack.Hotel.Entity.UserRole;
import com.HotelBack.Hotel.Repository.UserRoleRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final User user;
    private final UserRoleRepository userRoleRepository;

    public CustomUserDetails(User user, UserRoleRepository userRoleRepository) {
        this.user = user;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        UserRole userRole = userRoleRepository.findByUserId(user.getId());

        if(userRole != null) {
            return List.of(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return List.of();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
