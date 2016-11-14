package com.psp.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 风险类型
 */
@Entity
@Getter
public class RiskType {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    String name;

    public static RiskType build(String name) {
        final RiskType type = new RiskType();
        type.name = name;
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
