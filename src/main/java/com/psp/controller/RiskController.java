package com.psp.controller;

import com.psp.entity.User;
import com.psp.repository.RiskRepository;
import com.psp.service.RiskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Created by jankin on 12/11/2016.
 */
@Controller
@RequestMapping("/projects/{projectId:\\d+}/risks")
public class RiskController {
    private RiskRepository riskRepository;
    private RiskService riskService;

    @Inject
    RiskController(RiskRepository riskRepository,
                   RiskService riskService) {
        this.riskRepository = riskRepository;
        this.riskService = riskService;
    }

    @GetMapping
    @ResponseBody
    ResponseEntity<Model> index(@PathVariable Long projectId, Model model) {
        model.addAttribute("risks", riskRepository.findByProjectId(projectId));
        return ResponseEntity.ok(model);
//        return "risks/index";
    }

    @PostMapping
    String create(@PathVariable Long projectId,
                  @RequestParam String description,
                  @RequestParam String probability,
                  @RequestParam String impact,
                  @RequestParam String threshold,
                  @RequestParam String action,
                  @RequestParam Long riskTypeId,
                  @AuthenticationPrincipal User creator,
                  @RequestParam Long trackerId) {
        riskService.create(projectId, probability, impact, threshold, action, riskTypeId, creator, trackerId, description);
        return "redirect:/projects" + projectId;
    }
}
