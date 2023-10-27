package com.example.CRM.controllers;

import com.example.CRM.dto.request.ClientRequest;
import com.example.CRM.dto.request.EmployeeTypeRequest;
import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.dto.response.ClientStats;
import com.example.CRM.entities.Client;
import com.example.CRM.services.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
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
    public List<ClientResponse> getAllClients()
    {
        return clientServiceImp.getAllClients();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ClientResponse getClientById(@PathVariable("id") Long id)
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

    @GetMapping("/listbygroup/{id}")
    @ResponseBody
    public List<ClientResponse> listByGroupId(@PathVariable("id") Long id)
    {
        return clientServiceImp.getByGroupId(id);
    }

    @GetMapping("/listbyemployee/{id}")
    @ResponseBody
    public List<ClientResponse> listByEmployeeId(@PathVariable("id") Long id)
    {
        return clientServiceImp.getByEmployeeId(id);
    }

    @GetMapping("/countbyemployee/{id}")
    @ResponseBody
    public int countByEmployee(@PathVariable("id") Long id)
    {
        return clientServiceImp.getCountByEmployeeId(id);
    }

    @GetMapping("/getByEmployeeType")
    @ResponseBody
    public List<ClientResponse> fetchByEmployeeAndType(@RequestBody EmployeeTypeRequest request)
    {
        return clientServiceImp.fetchByEmployeeAndType(request.getEmployeeId(), request.getType());
    }

    @GetMapping("/getByAdmin/{id}")
    @ResponseBody
    public List<ClientResponse>fetchByAdminId(@PathVariable("id") Long id)
    {
        return clientServiceImp.getByAdminId(id);
    }


    @GetMapping("/getClientStats/{adminId}")
    @ResponseBody
    public ClientStats getClientStatistics(@PathVariable("adminId") Long adminId)
    {
        return clientServiceImp.getClientStats(adminId);
    }


}
