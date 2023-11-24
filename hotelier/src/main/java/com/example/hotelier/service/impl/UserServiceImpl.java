package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.UserRegistrationDTO;
import com.example.hotelier.model.entity.AgencyEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){

        AgencyEntity currentAgency = new AgencyEntity();

        currentAgency.setName(userRegistrationDTO.travelAgencyName());
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));

    }
}
