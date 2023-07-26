package com.example.CRM.repositories;

import com.example.CRM.entities.ETaskStatus;
import com.example.CRM.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus,Long> {
    Optional<TaskStatus> findByName(ETaskStatus name);
}
