package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.OpportunityResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Opportunity;

public class OpportunityMapper {
    public OpportunityResponse convertToDTO(Opportunity opportunity, UserResponseDTO employee)
    {
        OpportunityResponse opportunityResponse = new OpportunityResponse();

        opportunityResponse.setId(opportunity.getId());
        opportunityResponse.setName(opportunity.getName());
        opportunityResponse.setClosedate(opportunity.getClosedate());
        opportunityResponse.setAmount(opportunity.getAmount());
        opportunityResponse.setProbability(opportunity.getProbability());
        opportunityResponse.setStage(opportunity.getStage());
        opportunityResponse.setEmployee(employee);
        opportunityResponse.setCreatedat(opportunity.getCreatedat());
        opportunityResponse.setUpdatedat(opportunity.getUpdatedat());

        return opportunityResponse;
    }
}
