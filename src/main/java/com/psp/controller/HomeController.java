package com.psp.controller;

import com.psp.entity.Project;
import com.psp.entity.User;
import com.psp.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
 * Created by jankin on 11/11/2016.
 * 用户主页
 * - 项目列表
 * - 创建的风险列表
 * - 跟踪的风险列表
 */
@Controller
public class HomeController {
    private UserService userService;
    HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    String home() {
        return "forward:/home/projects";
    }

    @GetMapping("/home/projects")
    String projects(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        final Set<Project> projectCreated = userService.getProjectCreated(user);
        model.addAttribute("projects", projectCreated);
        return "home/projects";
    }

    @GetMapping("/home/risk_submited")
    String riskSubmited () {
        return "home/risk_submited";
    }

    @GetMapping("/home/risk_tracked")
    String riskTracked () {
        return "home/risk_tracked";
    }
}
