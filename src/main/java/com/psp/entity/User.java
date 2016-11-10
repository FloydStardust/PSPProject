package com.psp.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.List;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue
    Long id;
    @Column(unique = true)
    String name;
    @Email
    @Column(unique = true)
    String email;
    String passwordDigest;

    public static User create(String name, String password, String email) {
        User user = new User();
        user.name = name;
        user.passwordDigest = new BCryptPasswordEncoder(11).encode(password);
        user.email = email;
        return user;
    }
}
