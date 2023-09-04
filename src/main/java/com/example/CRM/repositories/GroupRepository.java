package com.example.CRM.repositories;

import com.example.CRM.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
     List<Group> findByAdminId(Long adminId);
}
