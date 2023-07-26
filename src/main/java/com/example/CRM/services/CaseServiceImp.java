package com.example.CRM.services;

import com.example.CRM.entities.Case;
import com.example.CRM.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImp implements CaseService{

    private final CaseRepository caseRepository;
    @Autowired
    public CaseServiceImp(CaseRepository caseRepository)
    {
        this.caseRepository=caseRepository;
    }

    @Override
    public Case addCaseAndAssignToClient(Case newcase) {
        return caseRepository.save(newcase);
    }

    @Override
    public Case updateCase(Case newcase) {
        return caseRepository.save(newcase);
    }

    @Override
    public Case getCaseById(Long id) {
        return caseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public void deleteCase(Long id) {
        caseRepository.deleteById(id);
    }
}
