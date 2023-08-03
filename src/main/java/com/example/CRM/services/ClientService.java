package com.example.CRM.services;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.entities.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(ClientRequest client);
    public Client updateClient(ClientRequest client,Long id);
    public Client getClientById(Long id);
    public List<Client> getAllClients();
    public void deleteClient(Long id);

}
