package com.psp.controller;

import com.psp.entity.*;
import com.psp.repository.*;
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
    private RoleTypeRepository roleTypeRepository;
    private RiskRepository riskRepository;
    private RiskTypeRepository riskTypeRepository;
    private TrackRecordRepository trackRecordRepository;

    @Inject
    ProjectController(ProjectService projectService,
                      ProjectRepository projectRepository,
                      RoleRepository roleRepository,
                      RoleTypeRepository roleTypeRepository,
                      RiskRepository riskRepository,
                      RiskTypeRepository riskTypeRepository,
                      TrackRecordRepository trackRecordRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.roleRepository = roleRepository;
        this.roleTypeRepository = roleTypeRepository;
        this.riskRepository = riskRepository;
        this.riskTypeRepository = riskTypeRepository;
        this.trackRecordRepository = trackRecordRepository;
    }

    @GetMapping("/{id:\\d+}")
    String show(@PathVariable Long id, Model model) {
        final Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        final Set<Role> roles = roleRepository.findByProject(project);
        model.addAttribute("roles", roles);
        model.addAttribute("roleTypes", roleTypeRepository.findAll());
        final Set<Risk> risks = riskRepository.findByProject(project);
        model.addAttribute("risks", risks);
        model.addAttribute("riskTypes", riskTypeRepository.findAll());
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
