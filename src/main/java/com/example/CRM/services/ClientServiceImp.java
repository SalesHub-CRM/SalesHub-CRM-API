package com.example.CRM.services;

import com.example.CRM.components.UserServiceComponent;
import com.example.CRM.dto.mapper.ClientMapper;
import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.dto.response.ClientStats;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Campaign;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.EClientType;
import com.example.CRM.entities.Group;
import com.example.CRM.repositories.CampaignRepository;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.GroupRepository;
import com.example.CRM.utils.UtilsFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService{
    private final ClientRepository clientRepository;
    private final GroupRepository groupRepository;
    private final UserServiceComponent userServiceComponent;
    private final UtilsFunctions utilsFunctions;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository, UserServiceComponent userServiceComponent,GroupRepository groupRepository,UtilsFunctions utilsFunctions)
    {
        this.clientRepository=clientRepository;
        this.userServiceComponent=userServiceComponent;
        this.groupRepository=groupRepository;
        this.utilsFunctions=utilsFunctions;
    }


    @Override
    public Client addClient(ClientRequest client) {
        Group group = groupRepository.findById(client.getGroupId()).orElse(null);

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
        clt.setGroup(group);

        return clientRepository.save(clt);
    }

    @Override
    public Client updateClient(ClientRequest client,Long id) {
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

    @Override
    public List<ClientResponse> getByGroupId(Long groupId) {
        List<Client>clients = clientRepository.findByGroupId(groupId);
        List<ClientResponse>clientResponses=new ArrayList<>();
        ClientMapper clientMapper = new ClientMapper();

        for (Client client : clients)
        {
            UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());
            ClientResponse clientResponse = clientMapper.convertToDTO(client,user);
            clientResponses.add(clientResponse);
        }
        return clientResponses;
    }

    @Override
    public int getCountByEmployeeId(Long employeeId) {
        List<Client>clients=clientRepository.findByEmployeeId(employeeId);
        return clients.size();
    }

    @Override
    public List<ClientResponse> getByEmployeeId(Long employeeId) {

        List<Client>clients=clientRepository.findByEmployeeId(employeeId);

        List<ClientResponse>clientResponses=new ArrayList<>();
        ClientMapper clientMapper = new ClientMapper();

        for (Client client : clients)
        {
            UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());
            ClientResponse clientResponse = clientMapper.convertToDTO(client,user);
            clientResponses.add(clientResponse);
        }
        return clientResponses;
    }

    @Override
    public List<ClientResponse> fetchByEmployeeAndType(Long employeeId, EClientType type) {

        List<Client>clients=clientRepository.findByEmployeeIdAndType(employeeId,type);

        List<ClientResponse>clientResponses=new ArrayList<>();
        ClientMapper clientMapper = new ClientMapper();

        for (Client client : clients)
        {
            UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());
            ClientResponse clientResponse = clientMapper.convertToDTO(client,user);
            clientResponses.add(clientResponse);
        }
        return clientResponses;
    }

    @Override
    public List<ClientResponse> getByAdminId(Long adminId) {

        List<Group>groups=groupRepository.findByAdminId(adminId);
        List<ClientResponse>clientResponses=new ArrayList<>();
        ClientMapper clientMapper = new ClientMapper();

        for (Group group : groups)
        {
            List<Client>clients=group.getClients();
            for (Client client : clients)
            {
                UserResponseDTO user = userServiceComponent.fetchUserById(client.getEmployeeId());
                ClientResponse clientResponse = clientMapper.convertToDTO(client,user);
                clientResponses.add(clientResponse);
            }
        }

        return clientResponses;
    }

    @Override
    public ClientStats getClientStats(Long adminId) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        calendar.add(Calendar.MONTH,-1);


        List<Long> groupIds = groupRepository.findIdsByAdminId(adminId);
        System.out.println("groupIds");
        System.out.println(groupIds);

        Date firstDayOfCurrentMonth = utilsFunctions.getFirstDayOfMonth(currentDate);
        Date firstDayOfPreviousMonth = utilsFunctions.getFirstDayOfMonth(calendar.getTime());

        List<Client>clientsCreatedThisMonth=clientRepository.findByCreatedatBetweenAndGroupIdIn(firstDayOfCurrentMonth,currentDate,groupIds);
        List<Client>clientsCreatedLastMonth=clientRepository.findByCreatedatBetweenAndGroupIdIn(firstDayOfPreviousMonth,firstDayOfCurrentMonth,groupIds);

        List<Client>clientList=utilsFunctions.getClientListByAdminId(adminId);


        int totalClients= clientList.size();
        int clientsThisMonth = clientsCreatedThisMonth.size();
        int clientsPreviousMonth = clientsCreatedLastMonth.size();
        int difference = clientsThisMonth-clientsPreviousMonth;

        return new ClientStats(totalClients,clientsThisMonth,difference);
    }


}
