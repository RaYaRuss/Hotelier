package com.example.hotelier.service;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.model.dto.OfferDetailDTO;
import com.example.hotelier.model.dto.OfferSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;
import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

    Page<OfferSummaryDTO> getAllOffers(Pageable pageable);

    Optional<OfferDetailDTO> getOfferDetail(UUID offerId);

    void deleteOffer(UUID offerUUID);
}
