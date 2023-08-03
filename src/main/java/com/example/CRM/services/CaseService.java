package com.example.CRM.services;


import com.example.CRM.dto.request.CaseRequest;
import com.example.CRM.entities.Case;

import java.util.List;

public interface CaseService {
    public Case addCaseAndAssignToClient(CaseRequest newcase);
    public Case updateCase(CaseRequest newcase,Long id);
    public Case getCaseById(Long id);
    public List<Case>getAllCases();
    public void deleteCase(Long id);

}
