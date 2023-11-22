package com.example.hotelier.model.entity;

import com.example.hotelier.model.enums.HotelCategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "hotels")
public class HotelEntity extends BaseEntity {

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private HotelCategoryEnum category;

    @ManyToOne
    private HotelChainEntity hotelChain;

    public HotelChainEntity getHotelChain() {
        return hotelChain;
    }

    public HotelEntity setHotelChain(HotelChainEntity hotelChain) {
        this.hotelChain = hotelChain;
        return this;
    }

    public HotelCategoryEnum getCategory() {
        return category;
    }

    public HotelEntity setCategory(HotelCategoryEnum category) {

        this.category = category;
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
