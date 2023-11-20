package com.example.hotelier.repository;

import com.example.hotelier.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findAllByHotelChainId (Long id);

    HotelEntity findByName(String hotelName);
}
