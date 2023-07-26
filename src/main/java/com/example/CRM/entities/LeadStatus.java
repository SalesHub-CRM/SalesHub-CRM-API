package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
@Table(name="leadstatus")
public class LeadStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private ELeadStatus name;

    public LeadStatus(){
    }

    public LeadStatus(ELeadStatus name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public ELeadStatus getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(ELeadStatus name) {
        this.name = name;
    }
}
