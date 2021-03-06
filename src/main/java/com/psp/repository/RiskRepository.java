package com.psp.repository;

import com.psp.entity.Project;
import com.psp.entity.Risk;
import com.psp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by jankin on 12/11/2016.
 */
@Repository
public interface RiskRepository extends CrudRepository<Risk, Long> {
    Set<Risk> findByProject(Project project);

    Set<Risk> findByProjectId(Long id);

    Set<Risk> findByCreator(User creator);

    Set<Risk> findByTracker(User tracker);
}
