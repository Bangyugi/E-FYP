package com.bangvan.efyp.repository;

import com.bangvan.efyp.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<Major,Long> {
    Optional<Major> getByName(String majorName);
}
