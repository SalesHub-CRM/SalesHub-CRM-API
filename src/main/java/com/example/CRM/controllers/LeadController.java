package com.example.CRM.controllers;

import com.example.CRM.entities.Lead;
import com.example.CRM.services.LeadServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lead")
public class LeadController {
    private final LeadServiceImp leadServiceImp;
    @Autowired
    public LeadController(LeadServiceImp leadServiceImp) {
        this.leadServiceImp = leadServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Lead> getAllleads()
    {
        return leadServiceImp.getAllLeads();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Lead getLeadById(@PathVariable("id") Long id)
    {
        return leadServiceImp.getLeadById(id);
    }

    @PostMapping
    @ResponseBody
    public Lead addLead(@RequestBody Lead lead)
    {
        return leadServiceImp.addAndAssignLeadToEmployee(lead);
    }


    @PutMapping
    @ResponseBody
    public Lead updateLead(@RequestBody Lead lead)
    {
        return leadServiceImp.updateLead(lead);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteLead(@PathVariable("id") Long id)
    {
        leadServiceImp.deleteLead(id);
        return ("deleted successfully");
    }
}
