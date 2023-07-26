package com.example.CRM.services;

import com.example.CRM.entities.Opportunity;
import com.example.CRM.repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImp implements OpportunityService{
    private final OpportunityRepository opportunityRepository;
    @Autowired
    public OpportunityServiceImp(OpportunityRepository opportunityRepository)
    {
        this.opportunityRepository=opportunityRepository;
    }

    @Override
    public Opportunity addOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity updateOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Opportunity> GetAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @Override
    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }
}
