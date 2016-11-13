package com.psp.service;

import com.psp.entity.Role;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by jankin on 13/11/2016.
 */
public interface RoleService {
    @PreAuthorize("#role.project.creator.id == principal.id || " +
            "#role.user.id == principal.id")
    void delete(Role role);

    void deleteById(Long id);
}
