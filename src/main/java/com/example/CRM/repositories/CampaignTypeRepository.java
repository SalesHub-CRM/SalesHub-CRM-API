package com.example.CRM.repositories;

import com.example.CRM.entities.CampaignType;
import com.example.CRM.entities.ECampaignType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampaignTypeRepository extends JpaRepository<CampaignType,Long> {

    Optional<CampaignType> findByName(ECampaignType name);
}
