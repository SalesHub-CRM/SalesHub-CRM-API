package com.example.CRM.controllers;

import com.example.CRM.dto.request.ContactRequest;
import com.example.CRM.entities.Contact;
import com.example.CRM.services.ContactServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
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
    public Contact addContact(@RequestBody ContactRequest contact)
    {
        return contactServiceImp.addContact(contact);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Contact updateContact(@RequestBody ContactRequest contact,@PathVariable("id") Long id)
    {
        return contactServiceImp.updateContact(contact,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteContact(@PathVariable("id") Long id)
    {
        contactServiceImp.deleteContact(id);
        return ("deleted successfully");
    }

    @GetMapping("byGroup/{id}")
    @ResponseBody
    public List<Contact> getByGroup(@PathVariable("id") Long id)
    {
        return contactServiceImp.getByGroup(id);
    }

    @GetMapping("byClient/{id}")
    @ResponseBody
    public List<Contact> getByClient(@PathVariable("id") Long id)
    {
        return contactServiceImp.getByClient(id);
    }
}
