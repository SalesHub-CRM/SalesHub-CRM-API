package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class CampaignStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private ECampaignStatus name;

    public CampaignStatus() {
    }

    public CampaignStatus(ECampaignStatus name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public ECampaignStatus getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(ECampaignStatus name) {
        this.name = name;
    }
}
