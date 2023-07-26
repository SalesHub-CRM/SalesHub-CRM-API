package com.example.CRM.repositories;

import com.example.CRM.entities.CampaignStatus;
import com.example.CRM.entities.ECampaignStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampaignStatusRepository extends JpaRepository<CampaignStatus,Long> {
    Optional<CampaignStatus> findByName(ECampaignStatus name);
}
