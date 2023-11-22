package com.example.hotelier.repository;

import com.example.hotelier.model.entity.HotelChainEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelChainRepository extends JpaRepository<HotelChainEntity, Long> {

    @EntityGraph(
            value = "brandWithModels",
            attributePaths = "models"
    )
    @Query("SELECT h FROM HotelChainEntity h")
    List<HotelChainEntity> getAllHotelChains();
}
