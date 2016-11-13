package com.psp.repository;

import com.psp.entity.RiskType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jankin on 12/11/2016.
 */
@Repository
public interface RiskTypeRepository extends CrudRepository<RiskType, Long> {
}
