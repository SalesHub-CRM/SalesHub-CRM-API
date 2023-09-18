package com.example.CRM.services;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.entities.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(ClientRequest client);
    public Client updateClient(ClientRequest client,Long id);
    public ClientResponse getClientById(Long id);
    public List<ClientResponse> getAllClients();
    public void deleteClient(Long id);
    public List<ClientResponse>getByGroupId(Long groupId);

}
