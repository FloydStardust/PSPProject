package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RoleType {
    @Id
    @GeneratedValue
    Long id;
    String name;

    @Override
    public String toString() {
        return name;
    }
}
