package com.example.CRM.controllers;

import com.example.CRM.entities.Contact;
import com.example.CRM.services.ContactServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactServiceImp contactServiceImp;
    @Autowired

    public ContactController(ContactServiceImp contactServiceImp) {
        this.contactServiceImp = contactServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Contact> getAllContacts()
    {
        return contactServiceImp.getAllContacts();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Contact getContactById(@PathVariable("id") Long id)
    {
        return contactServiceImp.getContactById(id);
    }

    @PostMapping
    @ResponseBody
    public Contact addContact(@RequestBody Contact contact)
    {
        return contactServiceImp.addContact(contact);
    }


    @PutMapping
    @ResponseBody
    public Contact updateContact(@RequestBody Contact contact)
    {
        return contactServiceImp.updateContact(contact);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteContact(@PathVariable("id") Long id)
    {
        contactServiceImp.deleteContact(id);
        return ("deleted successfully");
    }
}
