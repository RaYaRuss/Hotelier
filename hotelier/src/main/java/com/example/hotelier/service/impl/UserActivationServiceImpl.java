package com.example.hotelier.service.impl;

import com.example.hotelier.model.events.UserRegisteredEvent;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.EmailService;
import com.example.hotelier.service.UserActivationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserActivationServiceImpl implements UserActivationService {
    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final EmailService emailService;
    private final UserRepository userRepository;


    public UserActivationServiceImpl(EmailService emailService,
                                     UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;

    }

    @EventListener(UserRegisteredEvent.class)
    @Override
    public void userRegistered(UserRegisteredEvent event) {
        emailService.sendRegistrationEmail(event.getUserEmail(), event.getUserEmail());
    }

}
