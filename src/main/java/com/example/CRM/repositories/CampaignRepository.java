package com.example.CRM.repositories;

import com.example.CRM.dto.response.CampaignResponse;
import com.example.CRM.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    List<Campaign>findByProduct_Id(Long productId);

    @Query("SELECT c FROM Campaign c " +
            "JOIN c.product p " +
            "JOIN p.opportunities o " +
            "JOIN o.client cl " +
            "JOIN cl.group g " +
            "WHERE g.id = :groupId")
    List<Campaign> findCampaignsByGroupId(Long groupId);

}
