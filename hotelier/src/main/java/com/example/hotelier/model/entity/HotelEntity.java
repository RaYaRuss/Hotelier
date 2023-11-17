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

    private String imageUrl;
    private String location;
    private int renovated;

    @ManyToOne
    private HotelChainEntity hotelChain;

    public HotelChainEntity getHotelChain() {
        return hotelChain;
    }

    public void setHotelChain(HotelChainEntity hotelChain) {
        this.hotelChain = hotelChain;
    }

    public HotelCategoryEnum getStars() {
        return stars;
    }

    public void setStars(HotelCategoryEnum stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRenovated() {
        return renovated;
    }

    public void setRenovated(int renovated) {
        this.renovated = renovated;
    }

    public HotelChainEntity getChain() {
        return chain;
    }

    public void setChain(HotelChainEntity chain) {
        this.chain = chain;
    }

    @ManyToOne
    private HotelChainEntity chain;

}
