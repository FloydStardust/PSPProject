package com.psp.controller;

import com.psp.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by jankin on 13/11/2016.
 */
@Controller
@RequestMapping("/projects/{projectId:\\d+}/roles")
public class RoleController {
    private RoleService roleService;

    @Inject
    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @DeleteMapping("/{roleId:\\d+}")
    void delete(@PathVariable Long roleId) {
        roleService.deleteById(roleId);
    }
}
