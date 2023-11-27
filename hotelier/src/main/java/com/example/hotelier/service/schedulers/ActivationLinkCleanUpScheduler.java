package com.example.hotelier.service.schedulers;

import com.example.hotelier.service.UserActivationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ActivationLinkCleanUpScheduler {

    public final UserActivationService userActivationService;

    public ActivationLinkCleanUpScheduler(UserActivationService userActivationService) {

        this.userActivationService = userActivationService;
    }


    @Scheduled(cron = "0 0 0 * * *") // once a day ; once a week (0 0 0 * * 0)
    public void cleanUp() {
        System.out.println("Trigger clean up" + LocalDate.now());

        userActivationService.cleapUpObsolateActivationLinks();
    }
}
