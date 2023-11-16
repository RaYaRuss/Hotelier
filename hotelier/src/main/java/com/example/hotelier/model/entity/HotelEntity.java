package com.example.hotelier.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotels")
public class HotelEntity extends BaseEntity {

    private String name;
    private String description;

    private String imageUrl;
    private String location;
    private int renovated;

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
