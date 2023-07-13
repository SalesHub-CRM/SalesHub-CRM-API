package com.example.CRM.services;

import com.example.CRM.entities.Lead;
import com.example.CRM.repositories.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImp implements LeadService{

    LeadRepository leadRepository;
    @Override
    public Lead addAndAssignLeadToEmployee(Lead lead) {
        return null;
    }

    @Override
    public Lead updateLead(Lead lead) {
        return null;
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

    }
}
