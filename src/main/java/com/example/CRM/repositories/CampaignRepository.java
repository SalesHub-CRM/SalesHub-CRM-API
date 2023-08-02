package com.example.CRM.repositories;

import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {




}
