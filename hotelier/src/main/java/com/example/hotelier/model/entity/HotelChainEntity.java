package com.example.hotelier.model.entity;

import jakarta.persistence.*;

import java.util.List;;

@Entity
@Table(name = "hotel_chains")
@NamedEntityGraph(
        name="hotelChainsWithModels",
        attributeNodes = @NamedAttributeNode("hotels")
)
public class HotelChainEntity extends BaseEntity {
    @Column(unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "hotelChain"
    )
    private List<HotelEntity> hotels;

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public HotelChainEntity setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
        return this;
    }

    public String getName() {
        return name;
    }

    public HotelChainEntity setName(String name) {
        this.name = name;
        return this;
    }

}
