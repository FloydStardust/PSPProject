package com.psp.controller;

import com.psp.entity.User;
import com.psp.service.TrackRecordService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

/**
 * Created by jankin on 14/11/2016.
 */
@Controller
@RequestMapping("/risks/{riskId:\\d+}")
public class TrackRecordController {
    private TrackRecordService trackRecordService;

    @Inject
    TrackRecordController(TrackRecordService trackRecordService) {
        this.trackRecordService = trackRecordService;
    }

    @PostMapping("/track")
    String track(@AuthenticationPrincipal User user,
                 @PathVariable Long riskId,
                 @RequestParam String description,
                 @RequestParam Boolean happened) {
        trackRecordService.create(description, happened, riskId);
        return "redirect:/home/risk_tracked";
    }
}
