package com.bangvan.efyp.repository;

import com.bangvan.efyp.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository {
    Optional<Role> findByName(String name);
}
