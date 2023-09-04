package com.example.CRM.services;

import com.example.CRM.dto.request.LeadRequest;
import com.example.CRM.dto.response.LeadResponse;
import com.example.CRM.entities.Lead;

import java.util.List;

public interface LeadService {
    public Lead addAndAssignLeadToEmployee(LeadRequest lead);
    public Lead updateLead(LeadRequest lead,Long id);
    public LeadResponse getLeadById(Long id);
    public List<LeadResponse>getAllLeads();
    public void deleteLead(Long id);

}
