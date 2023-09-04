package com.example.CRM.repositories;

import com.example.CRM.entities.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity,Long> {
    List<Opportunity>findByEmployeeId(Long employeeId);
}
