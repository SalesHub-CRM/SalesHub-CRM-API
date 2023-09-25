package com.example.CRM.repositories;

import com.example.CRM.entities.Client;
import com.example.CRM.entities.EClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client>findByGroupId(Long groupId);
    List<Client>findByEmployeeId(Long employeeId);
    List<Client>findByEmployeeIdAndType(Long employeeId, EClientType type);
}
