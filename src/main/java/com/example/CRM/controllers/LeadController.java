package com.example.CRM.controllers;

import com.example.CRM.dto.request.LeadRequest;
import com.example.CRM.dto.response.LeadResponse;
import com.example.CRM.entities.Lead;
import com.example.CRM.services.LeadServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
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
    public List<LeadResponse> getAllleads()
    {
        return leadServiceImp.getAllLeads();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public LeadResponse getLeadById(@PathVariable("id") Long id)
    {
        return leadServiceImp.getLeadById(id);
    }

    @PostMapping
    @ResponseBody
    public Lead addLead(@RequestBody LeadRequest lead)
    {
        return leadServiceImp.addAndAssignLeadToEmployee(lead);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Lead updateLead(@RequestBody LeadRequest lead,@PathVariable("id") Long id)
    {
        return leadServiceImp.updateLead(lead,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteLead(@PathVariable("id") Long id)
    {
        leadServiceImp.deleteLead(id);
        return ("deleted successfully");
    }

    @GetMapping("/byGroup/{id}")
    @ResponseBody()
    public List<LeadResponse> getLeadsByGroupId(@PathVariable("id") Long id)
    {
        return leadServiceImp.getLeadsByGroupId(id);
    }
}
