package com.psp.service;

import com.psp.entity.User;
import com.psp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jankin on 09/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String username, String password, String email) {
        final User user = User.create(username, password, email);
        return userRepository.save(user);
    }
}
