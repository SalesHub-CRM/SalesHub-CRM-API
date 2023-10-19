package com.example.CRM.controllers;

import com.example.CRM.dto.request.CaseRequest;
import com.example.CRM.entities.Case;
import com.example.CRM.entities.Client;
import com.example.CRM.services.CaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("*")
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

    @GetMapping("/byGroup/{id}")
    @ResponseBody
    public List<Case>getByGroup(@PathVariable("id") Long id)
    {
        return caseServiceImp.getByGroup(id);
    }


    @GetMapping("/byClient/{id}")
    @ResponseBody
    public List<Case>getByClient(@PathVariable("id") Long id)
    {
        return caseServiceImp.getByClient(id);
    }

    @GetMapping("/clientByCase/{id}")
    @ResponseBody
    public ResponseEntity<Client> getClientByCaseId(@PathVariable Long id) {
        Optional<Client> client = caseServiceImp.findClientByCaseId(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
