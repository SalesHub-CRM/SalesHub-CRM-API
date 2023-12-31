package com.example.CRM.repositories;

import com.example.CRM.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task>findByEmployeeId(Long employeeId);
    List<Task>findByGroupId(Long groupId);
    List<Task>findByAssignedto(Long assignedTo);
}
