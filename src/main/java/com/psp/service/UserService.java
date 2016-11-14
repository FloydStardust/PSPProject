package com.psp.service;

import com.psp.entity.User;

/**
 * Created by jankin on 09/11/2016.
 */
public interface UserService {
    User create(String username, String password, String email);
    User createIfNotExists(String username, String password, String email);
}
