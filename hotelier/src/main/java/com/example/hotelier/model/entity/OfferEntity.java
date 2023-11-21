package com.example.hotelier.model.entity;

import com.example.hotelier.model.enums.RoomTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

    @Entity
    @Table(name = "offers")
    public class OfferEntity extends BaseEntity{

        @JdbcTypeCode((Types.VARCHAR))
        private UUID uuid;
       // @NotNull
        @ManyToOne
        private HotelEntity hotel;

        @Column(nullable = false)
        private String description;

        @Enumerated(EnumType.STRING)
        private RoomTypeEnum roomType;

        @ManyToOne
        private UserEntity seller;

        @NotEmpty
        private String imageUrl;

        @Column(nullable = false)
        private BigDecimal price;
        @Positive
        @Column(nullable = false)
        private int nightsCount;
        @Column(nullable = false)
        private String location;

        @FutureOrPresent
        @Column(nullable = false)
        private String startDate;

    public UUID getUuid() {
        return uuid;
    }

    public OfferEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public OfferEntity setHotel(HotelEntity hotel) {
        this.hotel = hotel;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public OfferEntity setRoomType(RoomTypeEnum roomType) {
        this.roomType = roomType;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getNightsCount() {
        return nightsCount;
    }

    public OfferEntity setNightsCount(int nightsCount) {
        this.nightsCount = nightsCount;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public OfferEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public OfferEntity setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

}
