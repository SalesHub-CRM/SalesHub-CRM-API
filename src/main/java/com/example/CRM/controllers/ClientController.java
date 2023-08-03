package com.example.CRM.controllers;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.entities.Client;
import com.example.CRM.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientServiceImp clientServiceImp;
    @Autowired
    public ClientController(ClientServiceImp clientServiceImp)
    {
        this.clientServiceImp=clientServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Client> getAllClients()
    {
        return clientServiceImp.getAllClients();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Client getClientById(@PathVariable("id") Long id)
    {
        return clientServiceImp.getClientById(id);
    }

    @PostMapping
    @ResponseBody
    public Client addClient(@RequestBody ClientRequest client)
    {
        return clientServiceImp.addClient(client);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Client updateClient(@RequestBody ClientRequest client,@PathVariable("id") Long id)
    {
        return clientServiceImp.updateClient(client,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteClient(@PathVariable("id") Long id)
    {
        clientServiceImp.deleteClient(id);
        return ("deleted successfully");
    }
}
