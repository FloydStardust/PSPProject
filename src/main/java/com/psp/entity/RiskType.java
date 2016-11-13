package com.psp.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class RiskType {
    @Id
    @GeneratedValue
    Long id;
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
