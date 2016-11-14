package com.psp.service;

import com.psp.entity.Risk;
import com.psp.entity.TrackRecord;
import com.psp.repository.RiskRepository;
import com.psp.repository.TrackRecordRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by jankin on 14/11/2016.
 */
@Service
public class TrackRecordServiceImpl implements TrackRecordService {
    private TrackRecordRepository trackRecordRepository;
    private RiskRepository riskRepository;

    @Inject
    TrackRecordServiceImpl(TrackRecordRepository trackRecordRepository,
                           RiskRepository riskRepository) {
        this.trackRecordRepository = trackRecordRepository;
        this.riskRepository = riskRepository;
    }

    @Override
    public TrackRecord create(String description, Boolean happened, Long riskId) {
        final Risk risk = riskRepository.findOne(riskId);
        final TrackRecord record = TrackRecord.build(description, happened, risk);
        return trackRecordRepository.save(record);
    }
}
