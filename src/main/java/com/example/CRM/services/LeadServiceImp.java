package com.example.CRM.services;

import com.example.CRM.dto.request.LeadRequest;
import com.example.CRM.entities.Employee;
import com.example.CRM.entities.Lead;
import com.example.CRM.repositories.EmployeeRepository;
import com.example.CRM.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadServiceImp implements LeadService{

    private final LeadRepository leadRepository;
    private final EmployeeRepository employeeRepository;
    @Autowired
    public LeadServiceImp(LeadRepository leadRepository,EmployeeRepository employeeRepository)
    {
        this.leadRepository=leadRepository;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public Lead addAndAssignLeadToEmployee(LeadRequest lead) {
        System.out.println("start here");
        System.out.println(lead.getEmployeeID());

        Employee employee = employeeRepository.findById(lead.getEmployeeID()).orElse(null);

        System.out.println(employee.getEmail());
        Lead ld = new Lead();

        ld.setSalutation(lead.getSalutation());
        ld.setFirstname(lead.getFirstname());
        ld.setLastname(lead.getLastname());
        ld.setTitle(lead.getTitle());
        ld.setCompany(lead.getCompany());
        ld.setEmail(lead.getEmail());
        ld.setPhone(lead.getPhone());
        ld.setAddress(lead.getAddress());
        ld.setCity(lead.getCity());
        ld.setZipcode(lead.getZipcode());
        ld.setSource(lead.getSource());
        ld.setEmployeenumber(lead.getEmployeenumber());
        ld.setIndustry(lead.getIndustry());
        ld.setAnnualrevenue(lead.getAnnualrevenue());
        ld.setStatus(lead.getStatus());

        leadRepository.save(ld);

        ld.setEmployee(employee);

        return leadRepository.save(ld);
    }

    @Override
    public Lead updateLead(LeadRequest lead, Long id) {
        Employee employee = employeeRepository.findById(lead.getEmployeeID()).orElse(null);
        Lead ld = leadRepository.findById(id).orElse(null);

        ld.setSalutation(lead.getSalutation());
        ld.setFirstname(lead.getFirstname());
        ld.setLastname(lead.getLastname());
        ld.setTitle(lead.getTitle());
        ld.setCompany(lead.getCompany());
        ld.setEmail(lead.getEmail());
        ld.setPhone(lead.getPhone());
        ld.setAddress(lead.getAddress());
        ld.setCity(lead.getCity());
        ld.setZipcode(lead.getZipcode());
        ld.setSource(lead.getSource());
        ld.setEmployeenumber(lead.getEmployeenumber());
        ld.setIndustry(lead.getIndustry());
        ld.setAnnualrevenue(lead.getAnnualrevenue());
        ld.setStatus(lead.getStatus());
        ld.setEmployee(employee);

        return leadRepository.save(ld);
    }

    @Override
    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    @Override
    public void deleteLead(Long id) {
    leadRepository.deleteById(id);
    }
}
