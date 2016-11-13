package com.psp.repository;

import com.psp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jankin on 09/11/2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select u from User u where u.name = ?1 or u.email = ?1")
    Optional<User> findByNameOrEmail(String token);

    Optional<User> findByName(String name);
}
