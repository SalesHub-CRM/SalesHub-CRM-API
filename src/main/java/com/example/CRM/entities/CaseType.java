package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class CaseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private ECaseType name;

    public CaseType() {
    }

    public CaseType(ECaseType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public ECaseType getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(ECaseType name) {
        this.name = name;
    }
}
