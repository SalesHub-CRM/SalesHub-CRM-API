package com.example.CRM.services;

import com.example.CRM.entities.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client client);
    public Client updateClient(Client client);
    public Client getClientById(Long id);
    public List<Client> getAllClients();
    public void deleteClient(Long id);

}
