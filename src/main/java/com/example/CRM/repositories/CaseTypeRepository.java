package com.example.CRM.repositories;

import com.example.CRM.entities.CaseType;
import com.example.CRM.entities.ECaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaseTypeRepository extends JpaRepository<CaseType,Long> {
    Optional<CaseType> findByName(ECaseType name);
}
