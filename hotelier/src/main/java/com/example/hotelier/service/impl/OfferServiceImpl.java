package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.model.dto.OfferDetailDTO;
import com.example.hotelier.model.dto.OfferSummaryDTO;
import com.example.hotelier.model.entity.HotelEntity;
import com.example.hotelier.model.entity.OfferEntity;
import com.example.hotelier.repository.HotelRepository;
import com.example.hotelier.repository.OfferRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.OfferService;
import com.example.hotelier.service.exception.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    public final OfferRepository offerRepository;
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, HotelRepository hotelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = map(createOfferDTO);

        HotelEntity hotelEntity = hotelRepository.findById(createOfferDTO.hotelId())
                .orElseThrow(() ->
                new IllegalArgumentException("Hotel with id " + createOfferDTO.hotelId() + " not found!"));

//        UserEntity sellerEntity = userRepository.findByEmail(seller.getUsername()).orElseThrow(() ->
//                new IllegalArgumentException("User with email " + seller.getUsername() + " not found!"));

        newOffer.setHotel(hotelEntity);

        newOffer = offerRepository.save(newOffer);

        return newOffer.getUuid();
    }

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository.findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID) {
        return offerRepository
                .findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);

    }

    @Override
    public void deleteOffer(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }

    private static OfferDetailDTO mapAsDetails(OfferEntity offerEntity) {
        return new OfferDetailDTO(
                offerEntity.getId().toString(),
                offerEntity.getHotel().getHotelChain().getName(),
                offerEntity.getHotel().getName(),
                offerEntity.getStartDate(),
                offerEntity.getNightsCount(),
                offerEntity.getPrice(),
                offerEntity.getRoomType(),
                offerEntity.getImageUrl());

    }


    private static OfferSummaryDTO mapAsSummary(OfferEntity offerEntity) {
        return new OfferSummaryDTO(
                offerEntity.getId().toString(),
                offerEntity.getHotel().getHotelChain().getName(),
                offerEntity.getHotel().getName(),
                offerEntity.getStartDate(),
                offerEntity.getNightsCount(),
                offerEntity.getPrice(),
                offerEntity.getRoomType(),
                offerEntity.getImageUrl());

    }


    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
        OfferEntity newOffer = new OfferEntity();
        newOffer.setUuid(UUID.randomUUID())
                .setRoomType(createOfferDTO.roomType())
                .setDescription(createOfferDTO.description())
                .setNightsCount(createOfferDTO.nightsCount())
                .setPrice(BigDecimal.valueOf(createOfferDTO.price()))
                .setImageUrl(createOfferDTO.imageUrl())
                .setStartDate(createOfferDTO.startDate());

        return newOffer;

    }
}
