package com.example.CRM.controllers;

import com.example.CRM.entities.Opportunity;
import com.example.CRM.services.OpportunityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {
    private final OpportunityServiceImp opportunityServiceImp;
    @Autowired

    public OpportunityController(OpportunityServiceImp opportunityServiceImp) {
        this.opportunityServiceImp = opportunityServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Opportunity> getAllOpportunities()
    {
        return opportunityServiceImp.GetAllOpportunities();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Opportunity getOpportunityById(@PathVariable("id") Long id)
    {
        return opportunityServiceImp.getOpportunityById(id);
    }

    @PostMapping
    @ResponseBody
    public Opportunity addOpportunity(@RequestBody Opportunity opportunity)
    {
        return opportunityServiceImp.addOpportunity(opportunity);
    }


    @PutMapping
    @ResponseBody
    public Opportunity updateOpportunity(@RequestBody Opportunity opportunity)
    {
        return opportunityServiceImp.updateOpportunity(opportunity);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOpportunity(@PathVariable("id") Long id)
    {
        opportunityServiceImp.deleteOpportunity(id);
        return ("deleted successfully");
    }
}
