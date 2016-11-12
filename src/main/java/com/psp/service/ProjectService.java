package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.User;

/**
 * Created by jankin on 11/11/2016.
 */
public interface ProjectService {
    Project create(String name, User user);
}
