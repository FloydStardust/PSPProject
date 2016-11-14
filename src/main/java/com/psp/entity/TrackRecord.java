package com.psp.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 风险跟踪记录
 */
@Entity
@Getter
public class TrackRecord {
    @Id
    @GeneratedValue
    Long id;

    String description; // 跟踪记录

    Boolean happened;   // 风险是否变成问题

    @ManyToOne
    Risk risk;          // 所属的风险

    LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static TrackRecord build(String description, Boolean happened, Risk risk) {
        final TrackRecord record = new TrackRecord();
        record.description = description;
        record.happened = happened;
        record.risk = risk;
        return record;
    }
}
