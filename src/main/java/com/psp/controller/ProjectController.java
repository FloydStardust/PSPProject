package com.psp.controller;

import com.psp.entity.Project;
import com.psp.entity.User;
import com.psp.repository.ProjectRepository;
import com.psp.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jankin on 11/11/2016.
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    private ProjectRepository projectRepository;
    ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/{id:\\d+}")
    String index (@PathVariable Long id, Model model) {
        final Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        return "projects/show";
    }

    @PostMapping
    String create (@RequestParam String name, @AuthenticationPrincipal User user) {
        final Project projectCreated = projectService.create(name, user);
        return "redirect:/projects/" + projectCreated.getId();
    }

    @DeleteMapping("/{id:\\d+}")
    void delete (@PathVariable Long id) {
        projectRepository.delete(id);
    }

}
