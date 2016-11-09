package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Role {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Project project;

    @ManyToOne
    User user;

    @ManyToOne
    RoleType roleType;
}
