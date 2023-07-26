package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class CampaignType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private ECampaignType name;

    public CampaignType() {
    }

    public CampaignType(ECampaignType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public ECampaignType getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(ECampaignType name) {
        this.name = name;
    }
}
