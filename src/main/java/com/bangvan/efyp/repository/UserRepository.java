package com.bangvan.efyp.repository;

import com.bangvan.efyp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    Optional<User> findByUsername(String username);

    boolean existsByPhone(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);


}
