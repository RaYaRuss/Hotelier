package com.example.hotelier.controller;

import com.example.hotelier.model.dto.UserLoginDTO;
import com.example.hotelier.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

//    private UserLoginController userLoginController(UserService userService) {
//    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logoutUser() ;

        return "index";
    }


    @PostMapping("/users/login")
    public String login(UserLoginDTO userLoginDTO) {

       boolean loginSuccessful = (userService.loginUser(userLoginDTO));
       return loginSuccessful ? "index" : "auth-login";
    }

}
