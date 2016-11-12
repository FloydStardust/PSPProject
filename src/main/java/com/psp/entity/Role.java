package com.psp.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
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
