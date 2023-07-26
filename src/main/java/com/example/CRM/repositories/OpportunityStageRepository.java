package com.example.CRM.repositories;

import com.example.CRM.entities.EOpportunityStage;
import com.example.CRM.entities.OpportunityStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpportunityStageRepository extends JpaRepository<OpportunityStage,Long> {
    Optional<OpportunityStage> findByName(EOpportunityStage name);
}
