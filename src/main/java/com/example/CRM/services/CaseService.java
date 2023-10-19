package com.example.CRM.services;


import com.example.CRM.dto.request.CaseRequest;
import com.example.CRM.entities.Case;
import com.example.CRM.entities.Client;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    public Case addCaseAndAssignToClient(CaseRequest newcase);
    public Case updateCase(CaseRequest newcase,Long id);
    public Case getCaseById(Long id);
    public List<Case>getAllCases();
    public void deleteCase(Long id);
    public List<Case>getByGroup(Long groupId);
    public List<Case>getByClient(Long clientId);
    public Optional<Client> findClientByCaseId(Long caseId);

}
