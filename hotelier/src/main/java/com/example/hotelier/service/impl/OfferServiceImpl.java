package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.model.entity.HotelEntity;
import com.example.hotelier.model.entity.OfferEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.repository.HotelRepository;
import com.example.hotelier.repository.OfferRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.OfferService;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        return UUID.randomUUID();
    }

//    public final OfferRepository offerRepository;
//    private final HotelRepository hotelRepository;
//    private final UserRepository userRepository;
//
//    public OfferServiceImpl(OfferRepository offerRepository, HotelRepository hotelRepository, UserRepository userRepository) {
//        this.offerRepository = offerRepository;
//
//        this.hotelRepository = hotelRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UUID createOffer(CreateOfferDTO createOfferDTO) {
//
//        OfferEntity newOffer = map(createOfferDTO);
//
//        HotelEntity hotelEntity = hotelRepository.findById(createOfferDTO.hotelId())
//                .orElseThrow(() ->
//                new IllegalArgumentException("Hotel with id " + createOfferDTO.hotelId() + " not found!"));
//
////        UserEntity sellerEntity = userRepository.findByEmail(seller.getUsername()).orElseThrow(() ->
////                new IllegalArgumentException("User with email " + seller.getUsername() + " not found!"));
//
//        newOffer.setHotel(hotelEntity);
//
//        newOffer = offerRepository.save(newOffer);
//
//        return newOffer.getUuid();
//    }
//
//    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
//        OfferEntity newOffer = new OfferEntity();
//        newOffer.setUuid(UUID.randomUUID())
//                .setDescription(createOfferDTO.description())
//                .setLocation(createOfferDTO.location())
//                .setPrice(createOfferDTO.price())
//                .setImageUrl(createOfferDTO.imageUrl())
//                .setStartDate(createOfferDTO.startDate())
//                .setRoomType(createOfferDTO.roomType());
//
//        return newOffer;
//
//    }

}
