package com.example.CRM.services;

import com.example.CRM.entities.Lead;

import java.util.List;

public interface LeadService {
    public Lead addAndAssignLeadToEmployee(Lead lead);
    public Lead updateLead(Lead lead);
    public Lead getLeadById(Long id);
    public List<Lead>getAllLeads();
    public void deleteLead(Long id);

}
