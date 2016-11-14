package com.psp.service;

import com.psp.entity.TrackRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jankin on 14/11/2016.
 */
public interface TrackRecordService {
    @Transactional
    TrackRecord create(String description, Boolean happened, Long riskId);
}
