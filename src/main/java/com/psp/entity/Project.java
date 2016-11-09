package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by jankin on 09/11/2016.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ManyToOne
    User creater;
}
