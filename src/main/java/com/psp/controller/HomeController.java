package com.psp.controller;

import com.psp.entity.Project;
import com.psp.entity.Risk;
import com.psp.entity.User;
import com.psp.service.ProjectService;
import com.psp.service.RiskService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;
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
    private ProjectService projectService;
    private RiskService riskService;

    @Inject
    HomeController(ProjectService projectService,
                   RiskService riskService) {
        this.projectService = projectService;
        this.riskService = riskService;
    }

    @GetMapping("/home")
    String home() {
        return "forward:/home/projects";
    }

    @GetMapping("/home/projects")
    String projects(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        final Set<Project> projectsRelated = projectService.getProjectsRelatedTo(user);
        model.addAttribute("projects", projectsRelated);
        return "home/projects";
    }

    @GetMapping("/home/risk_submited")
    String riskSubmited(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        final Set<Risk> risksCreated = riskService.getRisksCreatedBy(user);
        model.addAttribute("risks", risksCreated);
        return "home/risk_submited";
    }

    @GetMapping("/home/risk_tracked")
    String riskTracked(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        final Set<Risk> risksTracked = riskService.getRisksTrackedBy(user);
        model.addAttribute("risks", risksTracked);
        return "home/risk_tracked";
    }
}
