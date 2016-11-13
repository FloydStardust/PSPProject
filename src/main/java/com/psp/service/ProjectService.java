package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by jankin on 11/11/2016.
 */
public interface ProjectService {
    Project create(String name, User user);

    @Transactional
    Set<Project> getProjectsCreatedBy(User user);
}
