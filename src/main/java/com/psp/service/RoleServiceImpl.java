package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.Role;
import com.psp.entity.RoleType;
import com.psp.entity.User;
import com.psp.exception.ResourceNotFoundException;
import com.psp.repository.ProjectRepository;
import com.psp.repository.RoleRepository;
import com.psp.repository.RoleTypeRepository;
import com.psp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by jankin on 13/11/2016.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    private RoleTypeRepository roleTypeRepository;

    @Inject
    RoleServiceImpl(RoleRepository roleRepository,
                    ProjectRepository projectRepository,
                    UserRepository userRepository,
                    RoleTypeRepository roleTypeRepository) {
        this.roleRepository = roleRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.roleTypeRepository = roleTypeRepository;
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long id) {
        Role role = roleRepository.findOne(id);
        if (role == null) {
            throw new ResourceNotFoundException("role not found");
        } else {
            delete(role);
        }
    }

    @Override
    public Role create(Long projectId, Long userId, String roleTypeName) {
        final Project project = projectRepository.findOne(projectId);
        final User user = userRepository.findOne(userId);
        final Optional<RoleType> type = roleTypeRepository.findByName(roleTypeName);
        if (type.isPresent()) {
            return create(project, user, type.get());
        } else {
            final RoleType savedType = roleTypeRepository.save(RoleType.build(roleTypeName));
            return create(project, user, savedType);
        }
    }

    @Override
    public Role create(Project project, User user, RoleType type) {
        return roleRepository.save(Role.build(project, user, type));
    }
}
