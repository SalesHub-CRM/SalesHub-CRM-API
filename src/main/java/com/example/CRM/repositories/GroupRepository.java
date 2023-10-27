package com.example.CRM.repositories;

import com.example.CRM.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
     List<Group> findByAdminId(Long adminId);
     /*List<Long>findIdsByAdminId(Long adminId);*/

     @Query("SELECT g.id FROM Group g WHERE g.adminId = :adminId")
     List<Long> findIdsByAdminId(@Param("adminId") Long adminId);

}
