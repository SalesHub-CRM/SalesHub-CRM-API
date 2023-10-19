package com.example.CRM.repositories;

import com.example.CRM.entities.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseRepository extends JpaRepository<Case,Long> {
    List<Case>findByClient_Group_Id(Long groupId);
    List<Case>findByClient_Id(Long clientId);
    Optional<Case> findById(Long id);
}
