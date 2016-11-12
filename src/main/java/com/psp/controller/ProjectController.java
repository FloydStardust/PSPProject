package com.psp.controller;

import com.psp.entity.*;
import com.psp.repository.ProjectRepository;
import com.psp.repository.RiskRepository;
import com.psp.repository.RoleRepository;
import com.psp.repository.TrackRecordRepository;
import com.psp.service.ProjectService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by jankin on 11/11/2016.
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private RiskRepository riskRepository;
    private TrackRecordRepository trackRecordRepository;

    @Inject
    ProjectController(ProjectService projectService,
                      ProjectRepository projectRepository,
                      RoleRepository roleRepository,
                      RiskRepository riskRepository,
                      TrackRecordRepository trackRecordRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.riskRepository = riskRepository;
        this.trackRecordRepository = trackRecordRepository;
    }

    @GetMapping("/{id:\\d+}")
    String show(@PathVariable Long id, Model model) {
        final Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        final Set<Role> roles = roleRepository.findByProject(project);
        model.addAttribute("roles", roles);
        final Set<Risk> risks = riskRepository.findByProject(project);
        model.addAttribute("risks", risks);
        final Set<TrackRecord> trackRecords = trackRecordRepository.findTop5ByRiskProjectOrderByCreatedAt(project);
        model.addAttribute("top5TrackRecords", trackRecords);
        return "projects/show";
    }

    @PostMapping
    String create(@RequestParam String name, @AuthenticationPrincipal User user) {
        final Project projectCreated = projectService.create(name, user);
        return "redirect:/projects/" + projectCreated.getId();
    }

    @DeleteMapping("/{id:\\d+}")
    void delete(@PathVariable Long id) {
        projectRepository.delete(id);
    }

}
