package com.example.hotelier.service.impl;

import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class HotelierUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    public HotelierUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found!"));

    }
    private UserDetails map(UserEntity userEntity){
        return User
                .withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(List.of()) // TODO - to add roles
                .build();
    }
}
