package com.example.hotelier.controller;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.service.HotelChainService;
import com.example.hotelier.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final HotelChainService hotelChainService;

    public OfferController(OfferService offerService, HotelChainService hotelChainService) {
        this.offerService = offerService;
        this.hotelChainService = hotelChainService;
    }


    @GetMapping("/offers/all")
    public String all() {
        return("offers");
    }

    @GetMapping("/offers/add")
    public String add(Model model) {

        model.addAttribute("hotelChains", hotelChainService.getAllHotelChains());
        return("offer-add");
    }

    @PostMapping("/offers/add")
    public String add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/offers/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return("details");
    }
}
