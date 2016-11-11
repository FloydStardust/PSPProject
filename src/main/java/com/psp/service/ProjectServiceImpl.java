package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.User;
import com.psp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jankin on 11/11/2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    @Autowired
    ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    @Override
    public Project create(String name, User user) {
        return projectRepository.save(Project.create(name, user));
    }
}
