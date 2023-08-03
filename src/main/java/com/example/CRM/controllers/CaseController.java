package com.example.CRM.controllers;

import com.example.CRM.dto.request.CaseRequest;
import com.example.CRM.entities.Case;
import com.example.CRM.services.CaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/case")
public class CaseController {
    private final CaseServiceImp caseServiceImp;
    @Autowired
    public CaseController(CaseServiceImp caseServiceImp)
    {
        this.caseServiceImp=caseServiceImp;
    }

    @GetMapping
    @ResponseBody
    public List<Case>getAllCases()
    {
        return caseServiceImp.getAllCases();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Case getCaseById(@PathVariable("id") Long id)
    {
        return caseServiceImp.getCaseById(id);
    }

    @PostMapping
    @ResponseBody
    public Case addCase(@RequestBody CaseRequest cas)
    {
        return caseServiceImp.addCaseAndAssignToClient(cas);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Case updateCase(@RequestBody CaseRequest cas,@PathVariable("id") Long id)
    {
        return caseServiceImp.updateCase(cas,id);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteCase(@PathVariable("id") Long id)
    {
        caseServiceImp.deleteCase(id);
        return ("deleted successfully");
    }
}
