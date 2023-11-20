package com.example.hotelier.model.dto;

import com.example.hotelier.model.enums.HotelCategoryEnum;
import com.example.hotelier.model.enums.RoomTypeEnum;

import java.math.BigDecimal;
public record CreateOfferDTO(
        String description,

        Long hotelId,
        //UserEntity seller,

        HotelCategoryEnum category,

        RoomTypeEnum roomType,
        String imageUrl,
        BigDecimal price,
        int nightsCount,
        String location,
        String startDate) {

    public static CreateOfferDTO empty() {
        return new CreateOfferDTO(null,null, null,null, null, null, 0, null, null);
    }
}
