package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class TrackRecord {
    @Id
    @GeneratedValue
    Long id;

    String description; // 跟踪记录

    Boolean happened;   // 风险是否变成问题

    @ManyToOne
    Risk risk;          // 所属的风险
}
