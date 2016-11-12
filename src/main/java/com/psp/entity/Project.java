package com.psp.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Project {
    @Id
    @GeneratedValue
    Long id;
    String name;

    @ManyToOne
    User creator;

    public static Project create(String name, User creator) {
        Project project = new Project();
        project.name = name;
        project.creator = creator;
        return project;
    }
}
