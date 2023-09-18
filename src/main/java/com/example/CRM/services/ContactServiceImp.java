package com.example.CRM.services;

import com.example.CRM.dto.request.ContactRequest;
import com.example.CRM.entities.Client;
import com.example.CRM.entities.Contact;
import com.example.CRM.repositories.ClientRepository;
import com.example.CRM.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService{
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;
    @Autowired
    public ContactServiceImp(ContactRepository contactRepository,ClientRepository clientRepository)
    {
        this.contactRepository=contactRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    public Contact addContact(ContactRequest contact) {
        Client client=clientRepository.findById(contact.getClientId()).orElse(null);
        Contact cnt=new Contact();
        cnt.setSalutation(contact.getSalutation());
        cnt.setFirstname(contact.getFirstname());
        cnt.setLastname(contact.getLastname());
        cnt.setTitle(contact.getTitle());
        cnt.setEmail(contact.getEmail());
        cnt.setPhone(contact.getPhone());
        cnt.setAddress(contact.getAddress());
        cnt.setAddress2(contact.getAddress2());
        cnt.setCity(contact.getCity());
        cnt.setZipcode(contact.getZipcode());
        cnt.setClient(client);
        return contactRepository.save(cnt);
    }

    @Override
    public Contact updateContact(ContactRequest contact,Long id) {
        Client client=clientRepository.findById(contact.getClientId()).orElse(null);
        Contact cnt=contactRepository.findById(id).orElse(null);
        cnt.setSalutation(contact.getSalutation());
        cnt.setFirstname(contact.getFirstname());
        cnt.setLastname(contact.getLastname());
        cnt.setTitle(contact.getTitle());
        cnt.setEmail(contact.getEmail());
        cnt.setPhone(contact.getPhone());
        cnt.setAddress(contact.getAddress());
        cnt.setAddress2(contact.getAddress2());
        cnt.setCity(contact.getCity());
        cnt.setZipcode(contact.getZipcode());
        cnt.setClient(client);
        return contactRepository.save(cnt);
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getByGroup(Long groupId) {
        return contactRepository.findByClient_Group_Id(groupId);
    }
}
