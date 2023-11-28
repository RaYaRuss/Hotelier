package com.example.hotelier.controller;


import com.example.hotelier.service.HotelChainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HotelChainController {

    private final HotelChainService hotelChainService;

    public HotelChainController(HotelChainService hotelChainService) {

        this.hotelChainService = hotelChainService;
    }


    @GetMapping("/hotelChains")
    public String hotelChains(Model model) {

        model.addAttribute("hotelChains", hotelChainService.getAllHotelChains());

        return "hotelChains";

    }
}
