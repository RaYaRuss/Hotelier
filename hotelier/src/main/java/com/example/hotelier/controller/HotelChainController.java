package com.example.hotelier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelChainController {

    @GetMapping("/hotelChains")
    public String allHotelChains() {
        return "hotelChains";
    }
}
