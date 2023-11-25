package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.UserRegistrationDTO;
import com.example.hotelier.model.entity.AgencyEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.model.entity.UserRoleEntity;
import com.example.hotelier.model.enums.UserRoleEnum;
import com.example.hotelier.repository.AgencyRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AgencyRepository agencyRepository;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AgencyRepository agencyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.agencyRepository = agencyRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){

        AgencyEntity currentAgency = new AgencyEntity();

        currentAgency.setName(userRegistrationDTO.travelAgencyName());
        agencyRepository.save(currentAgency);


        Optional<AgencyEntity> byId = agencyRepository.findById(currentAgency.getId());


        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()))
                .setConfirmPassword(passwordEncoder.encode(userRegistrationDTO.password()))
                .setTravelAgency(currentAgency);

    }
}
