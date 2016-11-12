package com.psp.repository;

import com.psp.entity.Project;
import com.psp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by jankin on 11/11/2016.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Set<Project> findByCreator(User user);
}
