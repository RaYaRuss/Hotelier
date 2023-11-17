package com.example.hotelier.controller;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/offers/all")
    public String all() {
        return("offers");
    }

    @GetMapping("/offer/add")
    public String add() {
        return("offer-add");
    }

    @PostMapping
    public String add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/offer/{uuid}details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return("details");
    }
}
