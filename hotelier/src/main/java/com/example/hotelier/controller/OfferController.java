package com.example.hotelier.controller;

import com.example.hotelier.model.dto.CreateOfferDTO;
import com.example.hotelier.model.dto.OfferDetailDTO;
import com.example.hotelier.service.HotelChainService;
import com.example.hotelier.service.OfferService;
import com.example.hotelier.service.exception.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        model.addAttribute("hotelChains", hotelChainService.getAllHotelChains());
        return("offer-add");
    }

    @PostMapping("/offer/add")
    public String add( @Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                       RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }

            UUID newOfferUUID = offerService.createOffer(createOfferDTO);

        return "redirect:/offer/" + newOfferUUID;
    }

    @GetMapping("/offer/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid, Model model) {

        OfferDetailDTO offerDetailDTO = offerService.getOfferDetail(uuid).orElseThrow(() ->
                new ObjectNotFoundException("Offer with uuid " + uuid + " not found!"));

        model.addAttribute("offer", offerDetailDTO);
        return "details";
    }

    @DeleteMapping("/offer/{uuid}")
    public String delete(@PathVariable("uuid") UUID uuid) {
        offerService.deleteOffer(uuid);

        return "redirect:/offers/all";
    }


}
