package com.bangvan.efyp.repository;

import com.bangvan.efyp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {



    Optional<User> findByUsername(String username);

    boolean existsByPhone(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByUserIdAndStatus(Long userId, boolean b);


}
