package com.example.hotelier.testUtils;

import com.example.hotelier.model.entity.OfferEntity;
import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TestDataUtil {

    @Autowired
    public OfferRepository offerRepository;


    public String createTestOffer(UserEntity owner) {

        OfferEntity offer = new OfferEntity();
        return null;

    }

}
