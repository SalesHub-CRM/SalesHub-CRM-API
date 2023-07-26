package com.example.CRM.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Date lastname;
    private Date productionstart;
    private String productionend;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Campaign> campaigns;

    @ManyToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;

}
