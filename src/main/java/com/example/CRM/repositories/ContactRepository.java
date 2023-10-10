package com.example.CRM.repositories;

import com.example.CRM.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact>findByClient_Group_Id(Long groupId);
    List<Contact>findByClientId(Long clientId);
}
