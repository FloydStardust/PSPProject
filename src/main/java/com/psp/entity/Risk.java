package com.psp.entity;

import javax.persistence.*;

@Entity
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

    static enum Probability {
        HIGH,
        MEDIUM,
        LOW,
    }

    static enum Impact {
        HIGH,
        MEDIUM,
        LOW,
    }
}
