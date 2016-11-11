package com.psp.service;

import com.psp.entity.User;
import com.psp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nameOrEmail) throws UsernameNotFoundException {
        final Optional<User> userMaybe = userRepository.findByNameOrEmail(nameOrEmail);
        if (userMaybe.isPresent()) {
            return userMaybe.get();
        } else {
            throw new UsernameNotFoundException(nameOrEmail + " not found");
        }
    }
}
