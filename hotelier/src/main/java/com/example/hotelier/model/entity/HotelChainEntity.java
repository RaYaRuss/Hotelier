package com.example.hotelier.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel_chains")
public class HotelChainEntity extends BaseEntity {
    @Column(unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "hotelChain"
    )
    private List<HotelEntity> hotels;

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
