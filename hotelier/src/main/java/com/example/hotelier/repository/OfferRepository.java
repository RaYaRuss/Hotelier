package com.example.hotelier.repository;

import com.example.hotelier.model.entity.HotelChainEntity;
import com.example.hotelier.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}