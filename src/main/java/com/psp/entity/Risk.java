package com.psp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Risk {
    @Id
    @GeneratedValue
    Long id;

    String description; // 风险描述

    @Enumerated(EnumType.STRING)
    Probability probability; //可能性

    @Enumerated(EnumType.STRING)
    Impact impact;      // 影响程度

    String threshold;     // 触发情况

    String action;      // 应对措施
    @Setter
    Boolean happened;   // 是否变成问题

    Boolean closed;     // 是否关闭

    @ManyToOne
    Project project;    // 所属项目
    @ManyToOne
    RiskType type;      // 风险类型
    @ManyToOne
    User creator;       // 提交者
    @ManyToOne
    User tracker;       // 跟踪者

    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static enum Probability {
        HIGH,
        MEDIUM,
        LOW,
    }

    public static enum Impact {
        HIGH,
        MEDIUM,
        LOW,
    }

    public static Risk build(String description,
                             Probability probability,
                             Impact impact,
                             String threshold,
                             String action,
                             Project project,
                             RiskType type,
                             User creator,
                             User tracker) {
        Risk risk = new Risk();
        risk.description = description;
        risk.probability = probability;
        risk.impact = impact;
        risk.threshold = threshold;
        risk.action = action;
        risk.happened = false;
        risk.closed = false;
        risk.project = project;
        risk.type = type;
        risk.creator = creator;
        risk.tracker = tracker;
        return risk;
    }
}
