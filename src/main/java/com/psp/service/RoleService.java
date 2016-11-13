package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.Role;
import com.psp.entity.RoleType;
import com.psp.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jankin on 13/11/2016.
 */
public interface RoleService {
    @PreAuthorize("#role.project.creator.id == principal.id || " +
            "#role.user.id == principal.id")
    void delete(Role role);

    void deleteById(Long id);

    @Transactional
    Role create(Project project, User user, RoleType roleType);

    @Transactional
    Role create(Long projectId, Long userId, String roleTypeName);
}
