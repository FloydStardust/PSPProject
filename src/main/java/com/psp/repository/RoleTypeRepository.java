package com.psp.repository;

import com.psp.entity.RoleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by jankin on 13/11/2016.
 */
@Repository
public interface RoleTypeRepository extends CrudRepository<RoleType, Long> {

    Optional<RoleType> findByName(String name);
}
