package com.psp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by jankin on 09/11/2016.
 */
@Entity
public class Role {
    @Id
    @GeneratedValue
    Long id;
    String type;
}
