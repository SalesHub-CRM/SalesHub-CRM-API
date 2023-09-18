package com.example.CRM.services;

import com.example.CRM.dto.request.CaseRequest;
import com.example.CRM.entities.Case;
import com.example.CRM.entities.Client;
import com.example.CRM.repositories.CaseRepository;
import com.example.CRM.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImp implements CaseService{

    private final CaseRepository caseRepository;
    private final ClientRepository clientRepository;
    @Autowired
    public CaseServiceImp(CaseRepository caseRepository,ClientRepository clientRepository)
    {
        this.caseRepository=caseRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    public Case addCaseAndAssignToClient(CaseRequest newcase) {
        Client client = clientRepository.findById(newcase.getClientId()).orElse(null);
        Case ncs = new Case();

        ncs.setSubject(newcase.getSubject());
        ncs.setDescription(newcase.getDescription());
        ncs.setType(newcase.getType());
        ncs.setPriority(newcase.getPriority());
        ncs.setClient(client);
        return caseRepository.save(ncs);
    }

    @Override
    public Case updateCase(CaseRequest newcase,Long id) {
        Client client = clientRepository.findById(newcase.getClientId()).orElse(null);
        Case ncs = caseRepository.findById(id).orElse(null);
        ncs.setSubject(newcase.getSubject());
        ncs.setDescription(newcase.getDescription());
        ncs.setType(newcase.getType());
        ncs.setPriority(newcase.getPriority());
        ncs.setClient(client);
        return caseRepository.save(ncs);
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

    @Override
    public List<Case> getByGroup(Long groupId) {
        return caseRepository.findByClient_Group_Id(groupId);
    }
}
