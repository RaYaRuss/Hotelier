package com.example.hotelier.service;


import com.example.hotelier.model.events.UserRegisteredEvent;

public interface UserActivationService {

    void userRegistered(UserRegisteredEvent event);
}
