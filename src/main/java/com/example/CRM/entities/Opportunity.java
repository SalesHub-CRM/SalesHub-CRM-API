package com.example.CRM.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date closedate;
    private Double amount;
    private Integer probability;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "opportunity_stage_table",
            joinColumns = @JoinColumn(name = "opportunity_id"),
            inverseJoinColumns = @JoinColumn(name = "opportunitystage_id"))
    private Set<OpportunityStage> opportunitystages=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "opportunity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products;
}
