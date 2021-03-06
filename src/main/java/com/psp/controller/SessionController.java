package com.psp.controller;

import com.psp.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

/**
 * Created by jankin on 09/11/2016.
 */
@Controller
public class SessionController {
    private UserService userService;

    @Inject
    SessionController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/signup")
    String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    String signupAction(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String email,
                        HttpServletRequest request) {
        userService.create(username, password, email);
        return "redirect:/";
    }
}
