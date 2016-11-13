package com.psp.repository;

import com.psp.entity.Project;
import com.psp.entity.Risk;
import com.psp.entity.TrackRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by jankin on 12/11/2016.
 */
@Repository
public interface TrackRecordRepository extends CrudRepository<TrackRecord, Long> {
    Set<TrackRecord> findTop5ByRiskProjectOrderByCreatedAt(Project project);

    Set<TrackRecord> findByRisk(Risk risk);
}
