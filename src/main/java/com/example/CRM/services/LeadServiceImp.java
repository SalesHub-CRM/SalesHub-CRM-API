package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.LeadMapper;
import com.example.CRM.dto.request.LeadRequest;
import com.example.CRM.dto.response.LeadResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Lead;
import com.example.CRM.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadServiceImp implements LeadService{

    private final LeadRepository leadRepository;
    private final UserServiceComponent userServiceComponent;

    @Autowired
    public LeadServiceImp(LeadRepository leadRepository,UserServiceComponent userServiceComponent)
    {
        this.leadRepository=leadRepository;
        this.userServiceComponent=userServiceComponent;
    }
    @Override
    public Lead addAndAssignLeadToEmployee(LeadRequest lead) {
        System.out.println("start here");

        Lead ld = new Lead();

        ld.setSalutation(lead.getSalutation());
        ld.setFirstname(lead.getFirstname());
        ld.setLastname(lead.getLastname());
        ld.setTitle(lead.getTitle());
        ld.setCompany(lead.getCompany());
        ld.setEmail(lead.getEmail());
        ld.setPhone(lead.getPhone());
        ld.setAddress(lead.getAddress());
        ld.setCity(lead.getCity());
        ld.setZipcode(lead.getZipcode());
        ld.setSource(lead.getSource());
        ld.setEmployeenumber(lead.getEmployeenumber());
        ld.setIndustry(lead.getIndustry());
        ld.setAnnualrevenue(lead.getAnnualrevenue());
        ld.setStatus(lead.getStatus());
        ld.setEmployeeID(lead.getEmployeeID());

        return leadRepository.save(ld);
    }

    @Override
    public Lead updateLead(LeadRequest lead, Long id) {

        Lead ld = leadRepository.findById(id).orElse(null);

        ld.setSalutation(lead.getSalutation());
        ld.setFirstname(lead.getFirstname());
        ld.setLastname(lead.getLastname());
        ld.setTitle(lead.getTitle());
        ld.setCompany(lead.getCompany());
        ld.setEmail(lead.getEmail());
        ld.setPhone(lead.getPhone());
        ld.setAddress(lead.getAddress());
        ld.setCity(lead.getCity());
        ld.setZipcode(lead.getZipcode());
        ld.setSource(lead.getSource());
        ld.setEmployeenumber(lead.getEmployeenumber());
        ld.setIndustry(lead.getIndustry());
        ld.setAnnualrevenue(lead.getAnnualrevenue());
        ld.setStatus(lead.getStatus());
        ld.setEmployeeID(lead.getEmployeeID());

        return leadRepository.save(ld);
    }

    @Override
    public LeadResponse getLeadById(Long id) {
        Lead ld = leadRepository.findById(id).orElse(null);
        UserResponseDTO user = userServiceComponent.fetchUserById(ld.getEmployeeID());

        LeadMapper leadMapper = new LeadMapper();

        return leadMapper.convertToDTO(ld,user);
    }

    @Override
    public List<LeadResponse> getAllLeads() {

        List<Lead>allLeads=leadRepository.findAll();

        List<LeadResponse> leadResponses=new ArrayList<>();

        LeadMapper leadMapper = new LeadMapper();

        for(Lead lead : allLeads)
        {
            UserResponseDTO user = userServiceComponent.fetchUserById(lead.getEmployeeID());
            LeadResponse leadResponse = leadMapper.convertToDTO(lead,user);
            leadResponses.add(leadResponse);
        }

        return leadResponses;
    }

    @Override
    public void deleteLead(Long id) {
    leadRepository.deleteById(id);
    }
}
