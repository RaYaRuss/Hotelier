package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.UserRegistrationDTO;
import com.example.hotelier.model.entity.AgencyEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.model.events.UserRegisteredEvent;
import com.example.hotelier.repository.AgencyRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AgencyRepository agencyRepository;
    private final ApplicationEventPublisher appEventPublisher;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AgencyRepository agencyRepository, ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.agencyRepository = agencyRepository;
        this.appEventPublisher = appEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

        appEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDTO.email(),
                userRegistrationDTO.fullName()
        ));
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO){

        AgencyEntity currentAgency = new AgencyEntity();
        Optional<AgencyEntity> currentId = null;

        if (agencyRepository.findAll().stream().anyMatch(e -> Boolean.parseBoolean(userRegistrationDTO.travelAgencyName()))) {
            currentAgency = agencyRepository.findByName(userRegistrationDTO.travelAgencyName());
            currentId = agencyRepository.findById(currentAgency.getId());
        } else {
            currentAgency.setName(userRegistrationDTO.travelAgencyName());
            agencyRepository.save(currentAgency);
            Optional<AgencyEntity> byId = agencyRepository.findById(currentAgency.getId());
        }


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
