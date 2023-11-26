package com.example.hotelier.controller;


import com.example.hotelier.model.dto.UserRegistrationDTO;
import com.example.hotelier.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/users")
@Controller
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {

        return ("auth-register");

    }
    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {

        //TODO Register with activation link

        userService.registerUser(userRegistrationDTO);
        return "redirect:/";

    }
}
