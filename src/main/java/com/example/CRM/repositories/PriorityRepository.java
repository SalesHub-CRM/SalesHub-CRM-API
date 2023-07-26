package com.example.CRM.repositories;

import com.example.CRM.entities.EPriority;
import com.example.CRM.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {
    Optional<Priority> findByName(EPriority name);
}
