package com.psp.service;

import com.psp.entity.Project;
import com.psp.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by jankin on 09/11/2016.
 */
public interface UserService {
    User create(String username, String password, String email);
    User createIfNotExists(String username, String password, String email);
}
