package com.example.CRM.services;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.dto.response.ClientStats;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.EClientType;

import java.util.List;

public interface ClientService {
    public Client addClient(ClientRequest client);
    public Client updateClient(ClientRequest client,Long id);
    public ClientResponse getClientById(Long id);
    public List<ClientResponse> getAllClients();
    public void deleteClient(Long id);
    public List<ClientResponse>getByGroupId(Long groupId);
    public int getCountByEmployeeId(Long employeeId);
    public List<ClientResponse>getByEmployeeId(Long employeeId);
    public List<ClientResponse>fetchByEmployeeAndType(Long employeeId, EClientType type);
    public List<ClientResponse>getByAdminId(Long adminId);
    public ClientStats getClientStats(Long adminId);

}
