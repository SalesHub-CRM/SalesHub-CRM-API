package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class ClientType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private EClientType name;

    public ClientType() {
    }

    public ClientType(EClientType name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public EClientType getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(EClientType name) {
        this.name = name;
    }
}
