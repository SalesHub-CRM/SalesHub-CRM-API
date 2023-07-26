package com.example.CRM.services;


import com.example.CRM.entities.Case;

import java.util.List;

public interface CaseService {
    public Case addCaseAndAssignToClient(Case newcase);
    public Case updateCase(Case newcase);
    public Case getCaseById(Long id);
    public List<Case>getAllCases();
    public void deleteCase(Long id);

}
