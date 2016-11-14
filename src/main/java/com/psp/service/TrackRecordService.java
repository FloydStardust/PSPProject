package com.psp.service;

import com.psp.entity.TrackRecord;

/**
 * Created by jankin on 14/11/2016.
 */
public interface TrackRecordService {
    TrackRecord create(String description, Boolean happened, Long riskId);
}
