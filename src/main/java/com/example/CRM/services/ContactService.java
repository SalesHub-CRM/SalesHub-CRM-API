package com.example.CRM.services;

import com.example.CRM.dto.request.ContactRequest;
import com.example.CRM.entities.Contact;

import java.util.List;

public interface ContactService {
    public Contact addContact(ContactRequest contact);
    public Contact updateContact(ContactRequest contact,Long id);
    public Contact getContactById(Long id);
    public List<Contact> getAllContacts();
    public void deleteContact(Long id);
    public List<Contact>getByGroup(Long groupId);
}
