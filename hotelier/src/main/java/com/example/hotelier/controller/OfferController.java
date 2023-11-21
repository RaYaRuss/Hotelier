package com.example.hotelier.controller;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.service.HotelChainService;
import com.example.hotelier.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final HotelChainService hotelChainService;

    public OfferController(OfferService offerService, HotelChainService hotelChainService) {
        this.offerService = offerService;
        this.hotelChainService = hotelChainService;
    }



    @GetMapping("/offer/add")
    public String add(Model model) {

        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new CreateOfferDTO());
        }

        model.addAttribute("hotelChains", hotelChainService.getAllHotelChains());
        return("offer-add");
    }

    @PostMapping("/offer/add")
    public String add( @Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult, RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }

            offerService.createOffer(createOfferDTO);

        return "index";
    }

    @GetMapping("/offer/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return("details");
    }
}
