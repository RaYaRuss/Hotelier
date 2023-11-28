package com.example.hotelier.controller;

import com.example.hotelier.repository.AgencyRepository;
import com.example.hotelier.service.AgencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgencyController {

    private final AgencyService agencyService;
    private final AgencyRepository agencyRepository;

    public AgencyController(AgencyService agencyService, AgencyRepository agencyRepository) {

        this.agencyService = agencyService;
        this.agencyRepository = agencyRepository;
    }

    @GetMapping("/agencies")
    public String agencies(Model model) {

        model.addAttribute("agencies", agencyRepository.findAll());

        return "agencies";

    }
}
