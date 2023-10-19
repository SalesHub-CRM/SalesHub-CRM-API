package com.example.CRM.services;

import com.example.CRM.dto.request.OpportunityRequest;
import com.example.CRM.dto.response.OpportunityResponse;
import com.example.CRM.entities.Opportunity;

import java.util.List;

public interface OpportunityService {
    public Opportunity addOpportunity(OpportunityRequest opportunity);
    public Opportunity updateOpportunity(OpportunityRequest opportunity, Long id);
    public OpportunityResponse getOpportunityById(Long id);
    public List<OpportunityResponse> GetAllOpportunities();
    public void deleteOpportunity(Long id);
    public List<OpportunityResponse>listByEmployee(Long employeeId);
    public List<OpportunityResponse>listByGroupId(Long groupId);
    public List<OpportunityResponse>listByProductId(Long productId);
    public List<OpportunityResponse>listByClientId(Long clientId);
}
