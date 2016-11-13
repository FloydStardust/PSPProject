package com.psp.service;

import com.psp.entity.RoleType;
import com.psp.repository.RoleTypeRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by jankin on 13/11/2016.
 */
@Service
public class RoleTypeServiceImpl implements RoleTypeService {
    private RoleTypeRepository roleTypeRepository;

    @Inject
    RoleTypeServiceImpl(RoleTypeRepository roleTypeRepository) {
        this.roleTypeRepository = roleTypeRepository;
    }

    @Override
    public void setupRoleTypes() {
        String[] initialTypes = {"项目经理", "工程师", "开发经理", "支持经理"};
        for (String name : initialTypes) {
            createIfNotExists(name);
        }
    }

    private RoleType createIfNotExists(String name) {
        final Optional<RoleType> typeMaybe = roleTypeRepository.findByName(name);
        if (typeMaybe.isPresent()) {
            return typeMaybe.get();
        } else {
            return roleTypeRepository.save(RoleType.build(name));
        }
    }
}
