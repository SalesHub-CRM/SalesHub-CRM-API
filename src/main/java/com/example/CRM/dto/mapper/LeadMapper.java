package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.LeadResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Lead;

public class LeadMapper {
    public LeadResponse convertToDTO(Lead lead, UserResponseDTO user)
    {
        LeadResponse leadResponse = new LeadResponse();

        leadResponse.setId(lead.getId());
        leadResponse.setSalutation(lead.getSalutation());
        leadResponse.setFirstname(lead.getFirstname());
        leadResponse.setLastname(lead.getLastname());
        leadResponse.setTitle(lead.getTitle());
        leadResponse.setCompany(lead.getCompany());
        leadResponse.setEmail(lead.getEmail());
        leadResponse.setPhone(lead.getPhone());
        leadResponse.setAddress(lead.getAddress());
        leadResponse.setCity(lead.getCity());
        leadResponse.setZipcode(lead.getZipcode());
        leadResponse.setSource(lead.getSource());
        leadResponse.setEmployeenumber(lead.getEmployeenumber());
        leadResponse.setIndustry(lead.getIndustry());
        leadResponse.setAnnualrevenue(lead.getAnnualrevenue());
        leadResponse.setStatus(lead.getStatus());
        leadResponse.setUser(user);

        return leadResponse;
    }

}
