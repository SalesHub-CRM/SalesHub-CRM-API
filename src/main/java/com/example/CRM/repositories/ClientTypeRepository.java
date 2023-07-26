package com.example.CRM.repositories;

import com.example.CRM.entities.ClientType;
import com.example.CRM.entities.EClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientType,Long>{

    Optional<ClientType> findByName(EClientType name);
}
