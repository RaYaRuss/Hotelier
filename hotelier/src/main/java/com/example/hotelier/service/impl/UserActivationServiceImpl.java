package com.example.hotelier.service.impl;

import com.example.hotelier.model.entity.UserActivationCodeEntity;
import com.example.hotelier.model.events.UserRegisteredEvent;
import com.example.hotelier.repository.UserActivationCodeRepository;
import com.example.hotelier.repository.UserRepository;
import com.example.hotelier.service.EmailService;
import com.example.hotelier.service.UserActivationService;
import com.example.hotelier.service.exception.ObjectNotFoundException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

@Service
public class UserActivationServiceImpl implements UserActivationService {
    private static final String ACTIVATION_CODE_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789";
    private static final int ACTIVATION_CODE_LENGTH = 20;
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;



    public UserActivationServiceImpl(EmailService emailService,
                                     UserRepository userRepository, UserActivationCodeRepository userActivationCodeRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;

        this.userActivationCodeRepository = userActivationCodeRepository;
    }

    @EventListener(UserRegisteredEvent.class)
    @Override
    public void userRegistered(UserRegisteredEvent event) {
        String activationCode = createActivationCode(event.getUserEmail());
        emailService.sendRegistrationEmail
                (event.getUserEmail(), event.getUserNames(), activationCode);
    }

    @Override
    public void cleanUpObsoleteActivationLinks() {
        // TODO
    }

    @Override
    public String createActivationCode(String userEmail) {

        String activationCode = generateActivationCode();
        UserActivationCodeEntity userActivationCodeEntity = new UserActivationCodeEntity();
        userActivationCodeEntity.setActivationCode(generateActivationCode());
        userActivationCodeEntity.setCreated(Instant.now());
        userActivationCodeEntity.setUser(userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ObjectNotFoundException("User Not Found")));

        userActivationCodeRepository.save(userActivationCodeEntity);

        return activationCode;
    }

    private static String generateActivationCode() {

        StringBuilder activationCode = new StringBuilder();
        Random random = new SecureRandom();

        for (int i = 0; i<ACTIVATION_CODE_LENGTH; i++) {
            int randInd = random.nextInt(ACTIVATION_CODE_SYMBOLS.length());
            activationCode.append(ACTIVATION_CODE_SYMBOLS.charAt(randInd));
        }

        return  activationCode.toString();
    }
}
