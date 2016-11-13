package com.psp.repository;

import com.psp.entity.RiskType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jankin on 13/11/2016.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Slf4j
public class RiskTypeRepositoryTest {

    @Inject
    private RiskTypeRepository riskTypeRepository;

    @Test
    public void test() {
        riskTypeRepository.save(RiskType.build("范围风险"));
        riskTypeRepository.save(RiskType.build("进度风险"));
        assertThat(riskTypeRepository.count()).isEqualTo(2);
        for (RiskType type: riskTypeRepository.findAll()) {
            log.info("type: {}", type.getName());
        }
    }
}