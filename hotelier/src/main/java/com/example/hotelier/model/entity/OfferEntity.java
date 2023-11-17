package com.example.hotelier.model.entity;

import com.example.hotelier.model.enums.RoomTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;

@Entity
    @Table(name = "offers")
    public class OfferEntity extends BaseEntity{

        @JdbcTypeCode((Types.VARCHAR))
        private UUID uuid;
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
        private Date startDate;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public RoomTypeEnum getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEnum roomType) {
        this.roomType = roomType;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNightsCount() {
        return nightsCount;
    }

    public void setNightsCount(int nightsCount) {
        this.nightsCount = nightsCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    }
