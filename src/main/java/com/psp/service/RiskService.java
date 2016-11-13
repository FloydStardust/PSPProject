package com.psp.service;

import com.psp.entity.Risk;
import com.psp.entity.User;

import java.util.Set;

/**
 * Created by jankin on 12/11/2016.
 */
public interface RiskService {
    Risk create(Long projectId, String probability, String impact, String threshold, String action, Long riskTypeId, User creator, Long trackerId, String description);

    Set<Risk> getRisksCreatedBy(User creator);
    Set<Risk> getRisksTrackedBy(User tracker);
}
