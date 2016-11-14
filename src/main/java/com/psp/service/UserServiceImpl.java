package com.psp.service;

import com.psp.entity.User;
import com.psp.repository.ProjectRepository;
import com.psp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jankin on 09/11/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ProjectRepository projectRepository;
    @Autowired
    UserServiceImpl (UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public User create(String username, String password, String email) {
        final User user = User.build(username, password, email);
        return userRepository.save(user);
    }

    @Override
    public User createIfNotExists(String username, String password, String email) {
        final Optional<User> userMaybe = userRepository.findByName(username);
        if (userMaybe.isPresent()) {
            return userMaybe.get();
        } else {
            return create(username, password, email);
        }
    }
}
