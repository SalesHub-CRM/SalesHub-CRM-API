package com.example.CRM.dto.mapper;

import com.example.CRM.dto.response.ClientResponse;
import com.example.CRM.dto.response.UserResponseDTO;
import com.example.CRM.entities.Client;

public class ClientMapper {

    public ClientResponse convertToDTO (Client client, UserResponseDTO user)
    {
        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setId(client.getId());
        clientResponse.setName(client.getName());
        clientResponse.setParentname(client.getParentname());
        clientResponse.setPhone(client.getPhone());
        clientResponse.setFax(client.getFax());
        clientResponse.setEmail(client.getEmail());
        clientResponse.setWebsite(client.getWebsite());
        clientResponse.setEmployeenumber(client.getEmployeenumber());
        clientResponse.setAnnualrevenue(client.getAnnualrevenue());
        clientResponse.setIndustry(client.getIndustry());
        clientResponse.setBillingaddress(client.getBillingaddress());
        clientResponse.setShippingaddress(client.getShippingaddress());
        clientResponse.setType(client.getType());
        clientResponse.setUser(user);
        clientResponse.setContacts(client.getContacts());
        clientResponse.setCreatedat(client.getCreatedat());
        clientResponse.setUpdatedat(client.getUpdatedat());

        return clientResponse;
    }
}
