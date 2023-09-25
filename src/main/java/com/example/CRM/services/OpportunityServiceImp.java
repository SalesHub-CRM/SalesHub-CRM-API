package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.OpportunityMapper;
import com.example.CRM.dto.request.OpportunityRequest;
import com.example.CRM.dto.response.OpportunityResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.Group;
import com.example.CRM.entities.Opportunity;
import com.example.CRM.entities.Product;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.repositories.OpportunityRepository;
import com.example.CRM.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunityServiceImp implements OpportunityService{
    private final OpportunityRepository opportunityRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final UserServiceComponent userServiceComponent;
    @Autowired
    public OpportunityServiceImp(OpportunityRepository opportunityRepository,ClientRepository clientRepository,
                                 ProductRepository productRepository,UserServiceComponent userServiceComponent)
    {
        this.opportunityRepository=opportunityRepository;
        this.clientRepository=clientRepository;
        this.productRepository=productRepository;
        this.userServiceComponent=userServiceComponent;
    }

    @Override
    public Opportunity addOpportunity(OpportunityRequest opportunity) {

        Client client = clientRepository.findById(opportunity.getClientId()).orElse(null);
        Product product=productRepository.findById(opportunity.getProductId()).orElse(null);
        Opportunity opp = new Opportunity();

        opp.setName(opportunity.getName());
        opp.setClosedate(opportunity.getClosedate());
        opp.setAmount(opportunity.getAmount());
        opp.setProbability(opportunity.getProbability());
        opp.setStage(opportunity.getStage());
        opp.setEmployeeId(opportunity.getEmployeeId());
        opp.setClient(client);
        opp.setProduct(product);

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
    public OpportunityResponse getOpportunityById(Long id) {

        Opportunity opportunity = opportunityRepository.findById(id).orElse(null);
        UserResponseDTO employee = userServiceComponent.fetchUserById(opportunity.getEmployeeId());

        OpportunityMapper opportunityMapper = new OpportunityMapper();

        return opportunityMapper.convertToDTO(opportunity,employee);
    }

    @Override
    public List<OpportunityResponse> GetAllOpportunities() {

        List<Opportunity> opportunities = opportunityRepository.findAll();

        List<OpportunityResponse>opportunityResponses=new ArrayList<>();

        OpportunityMapper opportunityMapper = new OpportunityMapper();

        for(Opportunity opportunity : opportunities)
        {
            UserResponseDTO employee = userServiceComponent.fetchUserById(opportunity.getEmployeeId());
            OpportunityResponse opportunityResponse = opportunityMapper.convertToDTO(opportunity,employee);
            opportunityResponses.add(opportunityResponse);
        }

        return opportunityResponses;
    }

    @Override
    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }

    @Override
    public List<OpportunityResponse>listByEmployee(Long employeeId){

        List<Opportunity> opportunities = opportunityRepository.findByEmployeeId(employeeId);

        List<OpportunityResponse>opportunityResponses=new ArrayList<>();

        OpportunityMapper opportunityMapper = new OpportunityMapper();

        for(Opportunity opportunity : opportunities)
        {
            UserResponseDTO employee = userServiceComponent.fetchUserById(opportunity.getEmployeeId());
            OpportunityResponse opportunityResponse = opportunityMapper.convertToDTO(opportunity,employee);
            opportunityResponses.add(opportunityResponse);
        }

        return opportunityResponses;
    }

    @Override
    public List<OpportunityResponse> listByGroupId(Long groupId) {

        List<Opportunity> opportunities = opportunityRepository.findByClient_Group_Id(groupId);

        List<OpportunityResponse>opportunityResponses=new ArrayList<>();

        OpportunityMapper opportunityMapper = new OpportunityMapper();

        for(Opportunity opportunity : opportunities)
        {
            UserResponseDTO employee = userServiceComponent.fetchUserById(opportunity.getEmployeeId());
            OpportunityResponse opportunityResponse = opportunityMapper.convertToDTO(opportunity,employee);
            opportunityResponses.add(opportunityResponse);
        }

        return opportunityResponses;
    }
}
