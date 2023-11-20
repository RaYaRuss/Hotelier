package com.example.hotelier.service;

import com.example.hotelier.model.dto.CreateOfferDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
