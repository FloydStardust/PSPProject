package com.psp.controller;

import com.psp.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by jankin on 11/11/2016.
 * 用户主页
 * - 项目列表
 * - 创建的风险列表
 * - 跟踪的风险列表
 */
@Controller
public class HomeController {
    @GetMapping("/home")
    String home(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("projects", user.getProjectsCreated());
        model.addAttribute("risksCreated", Collections.emptyList());
        model.addAttribute("risksTracked", Collections.emptyList());
        return "home";
    }
}
