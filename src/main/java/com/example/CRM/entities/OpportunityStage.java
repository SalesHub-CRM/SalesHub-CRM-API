package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class OpportunityStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private EOpportunityStage name;

    public OpportunityStage() {
    }

    public OpportunityStage(EOpportunityStage name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public EOpportunityStage getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(EOpportunityStage name) {
        this.name = name;
    }
}
