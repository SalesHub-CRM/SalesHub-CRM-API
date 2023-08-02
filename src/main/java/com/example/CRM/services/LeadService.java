package com.example.CRM.services;

import com.example.CRM.dto.request.LeadRequest;
import com.example.CRM.entities.Lead;

import java.util.List;

public interface LeadService {
    public Lead addAndAssignLeadToEmployee(LeadRequest lead);
    public Lead updateLead(Lead lead,Long id);
    public Lead getLeadById(Long id);
    public List<Lead>getAllLeads();
    public void deleteLead(Long id);

}
