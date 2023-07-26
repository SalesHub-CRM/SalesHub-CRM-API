package com.example.CRM.services;

import com.example.CRM.entities.Contact;
import com.example.CRM.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService{
    private final ContactRepository contactRepository;
    @Autowired
    public ContactServiceImp(ContactRepository contactRepository)
    {
        this.contactRepository=contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
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
}
