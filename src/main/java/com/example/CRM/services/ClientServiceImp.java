package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.ClientMapper;
import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Campaign;
import com.example.CRM.entities.Client;
import com.example.CRM.repositories.CampaignRepository;
import com.example.CRM.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    private final CampaignRepository campaignRepository;
    private final UserServiceComponent userServiceComponent;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository,CampaignRepository campaignRepository, UserServiceComponent userServiceComponent)
    {
        this.clientRepository=clientRepository;
        this.campaignRepository=campaignRepository;
        this.userServiceComponent=userServiceComponent;
    }


    @Override
    public Client addClient(ClientRequest client) {

        Campaign campaign = campaignRepository.findById(client.getCampaignId()).orElse(null);
        Client clt = new Client();
        clt.setName(client.getName());
        clt.setParentname(client.getParentname());
        clt.setPhone(client.getPhone());
        clt.setFax(client.getFax());
        clt.setEmail(client.getEmail());
        clt.setWebsite(client.getWebsite());
        clt.setEmployeenumber(client.getEmployeenumber());
        clt.setAnnualrevenue(client.getAnnualrevenue());
        clt.setIndustry(client.getIndustry());
        clt.setBillingaddress(client.getBillingaddress());
        clt.setShippingaddress(client.getShippingaddress());
        clt.setType(client.getType());
        clt.setEmployeeId(client.getEmployeeId());
        clientRepository.save(clt);
        clt.setCampaign(campaign);
        return clientRepository.save(clt);
    }

    @Override
    public Client updateClient(ClientRequest client,Long id) {
        Campaign campaign = campaignRepository.findById(client.getCampaignId()).orElse(null);
        Client clt = clientRepository.findById(id).orElse(null);
        clt.setName(client.getName());
        clt.setParentname(client.getParentname());
        clt.setPhone(client.getPhone());
        clt.setFax(client.getFax());
        clt.setEmail(client.getEmail());
        clt.setWebsite(client.getWebsite());
        clt.setEmployeenumber(client.getEmployeenumber());
        clt.setAnnualrevenue(client.getAnnualrevenue());
        clt.setIndustry(client.getIndustry());
        clt.setBillingaddress(client.getBillingaddress());
        clt.setShippingaddress(client.getShippingaddress());
        clt.setType(client.getType());
        clt.setEmployeeId(client.getEmployeeId());
        clt.setCampaign(campaign);
        return clientRepository.save(clt);
    }

    @Override
    public ClientResponse getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());

        ClientMapper clientMapper = new ClientMapper();
        return clientMapper.convertToDTO(client,user);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        List<Client>allClients = clientRepository.findAll();
        List<ClientResponse>clientResponses=new ArrayList<>();
        ClientMapper clientMapper = new ClientMapper();

        for (Client client : allClients)
        {
            UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());
            ClientResponse clientResponse = clientMapper.convertToDTO(client,user);
            clientResponses.add(clientResponse);
        }
        return clientResponses;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
