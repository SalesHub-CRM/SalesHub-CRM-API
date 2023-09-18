package com.example.CRM.controllers;

import com.example.CRM.dto.request.OpportunityRequest;
import com.example.CRM.entities.Opportunity;
import com.example.CRM.services.OpportunityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
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
    public Opportunity addOpportunity(@RequestBody OpportunityRequest opportunity)
    {
        return opportunityServiceImp.addOpportunity(opportunity);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Opportunity updateOpportunity(@RequestBody OpportunityRequest opportunity,@PathVariable("id") Long id)
    {
        return opportunityServiceImp.updateOpportunity(opportunity,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteOpportunity(@PathVariable("id") Long id)
    {
        opportunityServiceImp.deleteOpportunity(id);
        return ("deleted successfully");
    }

    @GetMapping("/byEmployee/{id}")
    @ResponseBody
    public List<Opportunity> ListByEmployeeId(@PathVariable("id") Long id)
    {
        return opportunityServiceImp.listByEmployee(id);
    }

    @GetMapping("/bygroup/{id}")
    @ResponseBody
    public List<Opportunity> listByGroupId(@PathVariable("id") Long id)
    {
        return opportunityServiceImp.listByGroupId(id);
    }
}
