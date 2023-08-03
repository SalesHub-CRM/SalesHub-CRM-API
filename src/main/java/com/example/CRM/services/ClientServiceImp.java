package com.example.CRM.services;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.entities.Campaign;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.Employee;
import com.example.CRM.repositories.CampaignRepository;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final CampaignRepository campaignRepository;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository,EmployeeRepository employeeRepository,CampaignRepository campaignRepository)
    {
        this.clientRepository=clientRepository;
        this.employeeRepository=employeeRepository;
        this.campaignRepository=campaignRepository;
    }

    @Override
    public Client addClient(ClientRequest client) {
        Employee employee = employeeRepository.findById(client.getEmployeeId()).orElse(null);
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
        clientRepository.save(clt);
        clt.setEmployee(employee);
        clt.setCampaign(campaign);
        return clientRepository.save(clt);
    }

    @Override
    public Client updateClient(ClientRequest client,Long id) {
        Employee employee = employeeRepository.findById(client.getEmployeeId()).orElse(null);
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
        clt.setEmployee(employee);
        clt.setCampaign(campaign);
        return clientRepository.save(clt);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
