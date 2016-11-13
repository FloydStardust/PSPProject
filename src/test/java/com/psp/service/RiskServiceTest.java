package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.Risk;
import com.psp.entity.RiskType;
import com.psp.entity.User;
import com.psp.repository.RiskRepository;
import com.psp.repository.RiskTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jankin on 13/11/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class RiskServiceTest {
    @Inject
    private RiskTypeRepository riskTypeRepository;
    @Inject
    private RiskService riskService;
    @Inject
    private RiskRepository riskRepository;
    @Inject
    private ProjectService projectService;
    @Inject
    private UserService userService;

    private User creator, tracker;
    private RiskType riskTypeA, riskTypeB;
    private Project project;

    @Before
    public void setup() {
        creator = userService.create("creator", "creator", "creator@mail.com");
        tracker = userService.create("tracker", "tracker", "tracker@mail.com");
        riskTypeA = riskTypeRepository.save(RiskType.build("范围风险"));
        riskTypeB = riskTypeRepository.save(RiskType.build("进度风险"));
        project = projectService.create("测试项目", creator);
    }

    @Test
    public void testCreate() {
        final Risk risk = create();
        assertThat(riskRepository.findByProjectId(project.getId()).size()).isEqualTo(1);
    }

    @Test
    public void testCreatedAt() {
        LocalDateTime beforeCreate = LocalDateTime.now();
        final Risk risk = create();
        assertThat(risk.getCreatedAt().isAfter(beforeCreate));
    }

    private Risk create() {
        return riskService.create(project.getId(), "HIGH", "HIGH", "一周未完成项目", "赔偿", riskTypeB.getId(),
                creator, tracker.getId(), "规定时间未完成项目的风险");
    }
}