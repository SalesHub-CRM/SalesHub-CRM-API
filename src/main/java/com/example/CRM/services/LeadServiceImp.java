package com.example.CRM.services;

import com.example.CRM.entities.Lead;
import com.example.CRM.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImp implements LeadService{

    private final LeadRepository leadRepository;
    @Autowired
    public LeadServiceImp(LeadRepository leadRepository)
    {
        this.leadRepository=leadRepository;
    }
    @Override
    public Lead addAndAssignLeadToEmployee(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead updateLead(Lead lead) {
        return leadRepository.save(lead);
    }

    @Override
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public void deleteLead(Long id) {
    leadRepository.deleteById(id);
    }
}
