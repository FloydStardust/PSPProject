package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.Risk;
import com.psp.entity.RiskType;
import com.psp.entity.User;
import com.psp.repository.ProjectRepository;
import com.psp.repository.RiskRepository;
import com.psp.repository.RiskTypeRepository;
import com.psp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by jankin on 12/11/2016.
 */
@Service
public class RiskServiceImpl implements RiskService {
    private ProjectRepository projectRepository;
    private RiskTypeRepository riskTypeRepository;
    private UserRepository userRepository;
    private RiskRepository riskRepository;

    @Inject
    RiskServiceImpl(ProjectRepository projectRepository,
                    RiskTypeRepository riskTypeRepository,
                    UserRepository userRepository,
                    RiskRepository riskRepository) {
        this.projectRepository = projectRepository;
        this.riskTypeRepository = riskTypeRepository;
        this.userRepository = userRepository;
        this.riskRepository = riskRepository;
    }

    @Override
    public Risk create(Long projectId, String probability, String impact, String threshold,
                       String action, Long riskTypeId, User creator, Long trackerId, String description) {
        final Project project = projectRepository.findOne(projectId);
        final RiskType riskType = riskTypeRepository.findOne(riskTypeId);
        final User tracker = userRepository.findOne(trackerId);
        final Risk risk = Risk.build(description, Risk.Probability.valueOf(probability),
                Risk.Impact.valueOf(impact), threshold, action, project, riskType, creator, tracker);
        return riskRepository.save(risk);
    }

    @Override
    public Set<Risk> getRisksCreatedBy(User user) {
        return riskRepository.findByCreator(user);
    }

    @Override
    public Set<Risk> getRisksTrackedBy(User tracker) {
        return riskRepository.findByTracker(tracker);
    }

    @Override
    public Risk closeById(Long riskId) {
        final Risk risk = riskRepository.findOne(riskId);
        return close(risk);
    }

    @Override
    public Risk close(Risk risk) {
        risk.setClosed(true);
        return riskRepository.save(risk);
    }

    @Override
    public Risk updateById(Long riskId, String probability, String impact, String threshold) {
        final Risk risk = riskRepository.findOne(riskId);
        return update(risk, Risk.Probability.valueOf(probability), Risk.Impact.valueOf(impact), threshold);
    }

    @Override
    public Risk update(Risk risk, Risk.Probability probability, Risk.Impact impact, String threshold) {
        risk.setProbability(probability);
        risk.setImpact(impact);
        risk.setThreshold(threshold);
        return riskRepository.save(risk);
    }
}
