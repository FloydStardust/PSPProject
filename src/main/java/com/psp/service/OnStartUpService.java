package com.psp.service;

import com.psp.entity.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by jankin on 13/11/2016.
 */
@Service
public class OnStartUpService implements ApplicationListener<ApplicationReadyEvent> {
    private Environment env;
    private UserService userService;
    private RiskTypeService riskTypeService;

    @Inject
    OnStartUpService(UserService userService,
                     RiskTypeService riskTypeService,
                     Environment env) {
        this.userService = userService;
        this.riskTypeService = riskTypeService;
        this.env = env;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        if (env.acceptsProfiles("test")) return;

        userService.createIfNotExists("user", "pass", "user@mail.com");
        final User creator = userService.createIfNotExists("creator", "creator", "creator@mail.com");
        final User tracker = userService.createIfNotExists("tracker", "tracker", "tracker@mail.com");

        riskTypeService.setupRiskTypes();
    }
}
