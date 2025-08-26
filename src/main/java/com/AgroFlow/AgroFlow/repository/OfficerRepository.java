package com.AgroFlow.AgroFlow.repository;

import com.AgroFlow.AgroFlow.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, String> {
    Optional<Officer> findByOfficerId(String officerId);
}