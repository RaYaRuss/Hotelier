package com.example.hotelier.service.impl;


import com.example.hotelier.repository.AgencyRepository;
import com.example.hotelier.service.AgencyService;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {
    
    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }


}
