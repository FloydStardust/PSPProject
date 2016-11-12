package com.psp.repository;

import com.psp.entity.Project;
import com.psp.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by jankin on 12/11/2016.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findByProject(Project project);
}
