package com.example.hotelier.service.impl;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.model.dto.OfferDetailDTO;
import com.example.hotelier.model.dto.OfferSummaryDTO;
import com.example.hotelier.model.entity.HotelEntity;
import com.example.hotelier.model.entity.OfferEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.model.entity.UserRoleEntity;
import com.example.hotelier.model.enums.UserRoleEnum;
import com.example.hotelier.repository.HotelRepository;
import com.example.hotelier.repository.OfferRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.OfferService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    public final OfferRepository offerRepository;
    private final HotelRepository hotelRepository;
    //private final MonitoringService monitoringService;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, HotelRepository hotelRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO, UserDetails seller) {

        OfferEntity newOffer = map(createOfferDTO);

        HotelEntity hotelEntity = hotelRepository.findById(createOfferDTO.hotelId())
                .orElseThrow(() ->
                new IllegalArgumentException("Hotel with id " + createOfferDTO.hotelId() + " not found!"));

        UserEntity sellerEntity = userRepository.findByEmail(seller.getUsername()).orElseThrow(() ->
                new IllegalArgumentException("User with email " + seller.getUsername() + " not found!"));

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
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID, UserDetails viewer) {
        return offerRepository
                .findByUuid(offerUUID)
                .map(o -> this.mapAsDetails(o, viewer));

    }

    @Override
    @Transactional
    public void deleteOffer(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }

    private OfferDetailDTO mapAsDetails(OfferEntity offerEntity, UserDetails viewer) {

        return new OfferDetailDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getHotel().getHotelChain().getName(),
                offerEntity.getHotel().getName(),
                offerEntity.getStartDate(),
                offerEntity.getNightsCount(),
                offerEntity.getPrice(),
                offerEntity.getRoomType(),
                offerEntity.getImageUrl(),
                offerEntity.getSeller().getFirstName(),
                isOwner(offerEntity, viewer != null ? viewer.getUsername() : null));

    }

    @Override
    public boolean isOwner(UUID uuid, String userName) {
        return isOwner(
                offerRepository.findByUuid(uuid).orElse(null), userName
        );
    }

    private boolean isOwner(OfferEntity offerEntity, String userName) {
        if (offerEntity == null || userName == null) {
            // anonymous users own no offers
            // missing offers are meaningless
            return false;
        }

        UserEntity viewerEntity =
                userRepository
                        .findByEmail(userName)
                        .orElseThrow(() -> new IllegalArgumentException("Unknown user..."));

        if (isAdmin(viewerEntity)) {
            return true;
        }

        return Objects.equals(
                offerEntity.getSeller().getId(),
                viewerEntity.getId());

    }

    private boolean isAdmin(UserEntity userEntity) {

        return userEntity
                .getRoles().stream()
                .map(UserRoleEntity::getRole)
                .anyMatch(r -> UserRoleEnum.ADMIN == r);
    }


        private static OfferSummaryDTO mapAsSummary (OfferEntity offerEntity){
            return new OfferSummaryDTO(
                    offerEntity.getUuid().toString(),
                    offerEntity.getHotel().getHotelChain().getName(),
                    offerEntity.getHotel().getName(),
                    offerEntity.getStartDate(),
                    offerEntity.getNightsCount(),
                    offerEntity.getPrice(),
                    offerEntity.getRoomType(),
                    offerEntity.getImageUrl());
    }

    private static OfferEntity map(CreateOfferDTO createOfferDTO) {

       return new OfferEntity().setUuid(UUID.randomUUID())
                .setRoomType(createOfferDTO.roomType())
                .setDescription(createOfferDTO.description())
                .setNightsCount(createOfferDTO.nightsCount())
                .setPrice(BigDecimal.valueOf(createOfferDTO.price()))
                .setImageUrl(createOfferDTO.imageUrl())
                .setStartDate(createOfferDTO.startDate());

    }
}
