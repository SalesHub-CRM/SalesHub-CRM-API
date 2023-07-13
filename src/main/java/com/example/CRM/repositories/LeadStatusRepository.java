package com.example.CRM.repositories;

import com.example.CRM.entities.ELeadStatus;
import com.example.CRM.entities.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeadStatusRepository extends JpaRepository<LeadStatus,Long> {
    Optional<LeadStatus> findByName (ELeadStatus name);
}
