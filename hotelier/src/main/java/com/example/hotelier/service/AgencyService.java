package com.example.hotelier.service;

import com.example.hotelier.model.dto.UserRegistrationDTO;
import com.example.hotelier.model.entity.AgencyEntity;

public interface AgencyService {
    void safeAgencyEntity(UserRegistrationDTO userRegistrationDTO);

}
