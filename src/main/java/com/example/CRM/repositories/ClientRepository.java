package com.example.CRM.repositories;

import com.example.CRM.entities.Client;
import com.example.CRM.entities.EClientType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client>findByGroupId(Long groupId);
    List<Client>findByEmployeeId(Long employeeId);
    List<Client>findByEmployeeIdAndType(Long employeeId, EClientType type);
    List<Client>findByCreatedatBetween(Date startDate, Date endDate);
    List<Client>findByGroup_IdIn(List<Long> groupIds);

    @Query("SELECT c FROM Client c WHERE c.createdat BETWEEN :startDate AND :endDate AND c.group.id IN :groupIds")
    List<Client> findByCreatedatBetweenAndGroupIdIn(
            @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("groupIds") List<Long> groupIds
    );
}
