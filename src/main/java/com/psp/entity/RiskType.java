package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RiskType {
    @Id
    @GeneratedValue
    Long id;
    String name;
}
