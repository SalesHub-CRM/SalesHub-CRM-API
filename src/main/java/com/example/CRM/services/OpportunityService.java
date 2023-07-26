package com.example.CRM.services;

import com.example.CRM.entities.Opportunity;

import java.util.List;

public interface OpportunityService {
    public Opportunity addOpportunity(Opportunity opportunity);
    public Opportunity updateOpportunity(Opportunity opportunity);
    public Opportunity getOpportunityById(Long id);
    public List<Opportunity> GetAllOpportunities();
    public void deleteOpportunity(Long id);
}
