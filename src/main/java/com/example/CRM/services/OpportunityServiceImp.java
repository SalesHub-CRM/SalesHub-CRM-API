package com.example.CRM.services;

import com.example.CRM.dto.request.OpportunityRequest;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.Opportunity;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImp implements OpportunityService{
    private final OpportunityRepository opportunityRepository;
    private final ClientRepository clientRepository;
    @Autowired
    public OpportunityServiceImp(OpportunityRepository opportunityRepository,ClientRepository clientRepository)
    {
        this.opportunityRepository=opportunityRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    public Opportunity addOpportunity(OpportunityRequest opportunity) {

        Client client = clientRepository.findById(opportunity.getClientId()).orElse(null);

        Opportunity opp = new Opportunity();

        opp.setName(opportunity.getName());
        opp.setClosedate(opportunity.getClosedate());
        opp.setAmount(opportunity.getAmount());
        opp.setProbability(opportunity.getProbability());
        opp.setStage(opportunity.getStage());
        opp.setEmployeeId(opportunity.getEmployeeId());
        opportunityRepository.save(opp);

        opp.setClient(client);

        return opportunityRepository.save(opp);
    }

    @Override
    public Opportunity updateOpportunity(OpportunityRequest opportunity, Long id) {

        Client client = clientRepository.findById(opportunity.getClientId()).orElse(null);

        Opportunity opp = opportunityRepository.findById(id).orElse(null);

        opp.setName(opportunity.getName());
        opp.setClosedate(opportunity.getClosedate());
        opp.setAmount(opportunity.getAmount());
        opp.setProbability(opportunity.getProbability());
        opp.setStage(opportunity.getStage());
        opp.setEmployeeId(opportunity.getEmployeeId());
        opp.setClient(client);

        return opportunityRepository.save(opp);
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

    @Override
    public List<Opportunity>listByEmployee(Long employeeId){
        return opportunityRepository.findByEmployeeId(employeeId);
    }
}
