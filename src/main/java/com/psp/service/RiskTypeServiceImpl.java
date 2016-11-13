package com.psp.service;

import com.psp.entity.RiskType;
import com.psp.repository.RiskTypeRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by jankin on 13/11/2016.
 */
@Service
public class RiskTypeServiceImpl implements RiskTypeService {
    private RiskTypeRepository riskTypeRepository;

    @Inject
    RiskTypeServiceImpl(RiskTypeRepository riskTypeRepository) {
        this.riskTypeRepository = riskTypeRepository;
    }

    @Override
    public void setupRiskTypes() {
        String[] initialTypes = {"范围风险", "进度风险", "成本风险", "质量风险", "技术风险", "管理风险",
                "商业风险", "法律风险", "社会环境风险"};
        for (String name : initialTypes) {
            createIfNotExists(name);
        }
    }

    private RiskType createIfNotExists(String name) {
        final Optional<RiskType> typeMaybe = riskTypeRepository.findByName(name);
        if (typeMaybe.isPresent()) {
            return typeMaybe.get();
        } else {
            return riskTypeRepository.save(RiskType.build(name));
        }
    }
}
