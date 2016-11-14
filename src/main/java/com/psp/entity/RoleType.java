package com.psp.entity;

import javax.persistence.*;

/**
 * 角色类型
 */
@Entity
public class RoleType {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    String name;

    public static RoleType build(String name) {
        RoleType type = new RoleType();
        type.name = name;
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
