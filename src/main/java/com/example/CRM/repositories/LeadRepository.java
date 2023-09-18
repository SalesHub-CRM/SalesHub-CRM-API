package com.example.CRM.repositories;

import com.example.CRM.dto.response.LeadResponse;
import com.example.CRM.entities.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Long> {
    public List<Lead> getLeadsByGroupId(Long groupId);
}
