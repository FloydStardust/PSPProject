package com.psp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuredController {
    @GetMapping(path = "/secured")
    String securedHome() {
        return "secured";
    }
}
