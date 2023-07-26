package com.example.CRM.services;

import com.example.CRM.entities.Contact;

import java.util.List;

public interface ContactService {
    public Contact addContact(Contact contact);
    public Contact updateContact(Contact contact);
    public Contact getContactById(Long id);
    public List<Contact> getAllContacts();
    public void deleteContact(Long id);
}
