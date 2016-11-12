package com.psp.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    public void prePersist () {
        createdAt = LocalDateTime.now();
    }
}
