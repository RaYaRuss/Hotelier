package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.repository.OfferRepository;
import com.example.hotelier.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    public final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;

    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        //TODO
        throw new UnsupportedOperationException("Coming soon!");
    }
}
