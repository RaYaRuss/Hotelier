package com.example.hotelier.model.dto;

import com.example.hotelier.model.enums.HotelCategoryEnum;
import com.example.hotelier.model.enums.RoomTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
public record CreateOfferDTO(
        @NotEmpty @Size(min = 5, max = 512)
        String description,
        @Positive
        @NotNull
        Long hotelId,
        //UserEntity seller,

        HotelCategoryEnum category,

        RoomTypeEnum roomType,
        @NotEmpty
        String imageUrl,
        @Positive
        @NotNull
        BigDecimal price,
        @Positive
        @NotNull
        int nightsCount,
        String location,
        @Positive
        @NotNull
        String startDate) {

    public static CreateOfferDTO empty() {

        return new CreateOfferDTO(null,null, null,null, null, null, 0, null, null);
    }

    public CreateOfferDTO() {
      this   (null, null, null, null, null, null, 0, null, null);
    }
}
