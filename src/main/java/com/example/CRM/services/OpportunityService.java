package com.example.CRM.services;

import com.example.CRM.dto.request.OpportunityRequest;
import com.example.CRM.entities.Opportunity;

import java.util.List;

public interface OpportunityService {
    public Opportunity addOpportunity(OpportunityRequest opportunity);
    public Opportunity updateOpportunity(OpportunityRequest opportunity, Long id);
    public Opportunity getOpportunityById(Long id);
    public List<Opportunity> GetAllOpportunities();
    public void deleteOpportunity(Long id);
}
