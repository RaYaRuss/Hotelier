package com.example.hotelier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {

    @GetMapping("/login")
    public ModelAndView login() {

        return new ModelAndView("auth-login");
    }

    @GetMapping("/register")
    public ModelAndView register() {

        return new ModelAndView("auth-register");

    }
}
