package com.example.hotelier.model.dto;

import com.example.hotelier.model.enums.RoomTypeEnum;

import java.math.BigDecimal;

public record OfferDetailDTO (
        String id,
        String hotelChain,
        String hotel,
        String date,
        int nightsCount,
        BigDecimal price,
        RoomTypeEnum roomType,
        String imageUrl

) {
    public String summary() {
        return hotelChain + " " + hotel + " " + roomType;
    }
}
