package com.example.hotelier.model.dto;

import com.example.hotelier.model.enums.HotelCategoryEnum;
import com.example.hotelier.model.enums.RoomTypeEnum;
import com.example.hotelier.model.validation.StartDateNotInTheFuture;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateOfferDTO(
        @NotEmpty @Size(min = 5, max = 512)
        String description,
        @Positive
        @NotNull
        Long hotelId,
       @NotNull
        RoomTypeEnum roomType,
        @NotEmpty
        String imageUrl,
        @Positive
        @NotNull
        Integer price,
        @Positive
        @NotNull
        Integer nightsCount,
        // @StartDateNotInTheFuture
        @NotEmpty
        String startDate) {

    public static CreateOfferDTO empty() {

        return new CreateOfferDTO(null,null, null,null, null, null, null);
    }

//    public CreateOfferDTO() {
//      this   (null, null, null, null, null, null, null);
//    }
}
