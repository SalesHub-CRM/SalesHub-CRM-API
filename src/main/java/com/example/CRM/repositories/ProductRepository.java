package com.example.CRM.repositories;

import com.example.CRM.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    /*List<Product> findByOpportunity_Client_Group_Id(Long groupId);*/

    List<Product>findByOwnerId(Long ownerId);

    @Query("SELECT DISTINCT p FROM Product p " +
            "JOIN p.opportunities o " +
            "JOIN o.client c " +
            "JOIN c.group g " +
            "WHERE g.id = :groupId")
    List<Product> findProductsByGroupId(Long groupId);
}
