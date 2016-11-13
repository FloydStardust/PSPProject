package com.psp.service;

import com.psp.entity.Role;
import com.psp.exception.ResourceNotFoundException;
import com.psp.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by jankin on 13/11/2016.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Inject
    RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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
}
