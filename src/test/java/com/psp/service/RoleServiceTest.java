package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.RoleType;
import com.psp.entity.User;
import com.psp.repository.RoleTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jankin on 14/11/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class RoleServiceTest {
    @Inject
    private UserService userService;
    @Inject
    private RoleService roleService;
    @Inject
    private ProjectService projectService;
    @Inject
    private RoleTypeRepository roleTypeRepository;

    private User creator, tracker;
    private Project project;

    @Before
    public void setup() {
        creator = userService.createIfNotExists("creator", "creator", "creator@mail.com");
        tracker = userService.createIfNotExists("tracker", "tracker", "tracker@mail.com");
        project = projectService.create("测试项目", creator);
    }

    @Test
    public void testCreateRole() {
        assertThat(projectService.getProjectsRelatedTo(tracker)).isEmpty();
        assertThat(projectService.getProjectsRelatedTo(creator)).hasSize(1);
        roleService.create(project.getId(), tracker.getId(), "工程师");
        roleService.create(project.getId(), creator.getId(), "项目经理");
        assertThat(projectService.getProjectsRelatedTo(tracker)).hasSize(1);
        assertThat(projectService.getProjectsRelatedTo(creator)).hasSize(1);
        assertThat(roleTypeRepository.count()).isEqualTo(2);
    }
}