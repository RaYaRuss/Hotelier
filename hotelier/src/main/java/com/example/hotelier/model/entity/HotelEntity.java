package com.example.hotelier.model.entity;

import com.example.hotelier.model.enums.HotelCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class HotelEntity extends BaseEntity {

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private HotelCategoryEnum stars;

    @ManyToOne
    private HotelChainEntity hotelChain;

    public HotelChainEntity getHotelChain() {
        return hotelChain;
    }

    public HotelEntity setHotelChain(HotelChainEntity hotelChain) {
        this.hotelChain = hotelChain;
        return this;
    }

    public HotelCategoryEnum getStars() {
        return stars;
    }

    public HotelEntity setStars(HotelCategoryEnum stars) {

        this.stars = stars;
        return this;
    }

    public String getName() {
        return name;
    }

    public HotelEntity setName(String name) {

        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public HotelEntity setDescription(String description) {

        this.description = description;
        return this;
    }
}
