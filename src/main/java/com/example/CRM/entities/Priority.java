package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private EPriority name;

    public Priority() {
    }

    public Priority(EPriority name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public EPriority getName() {
        return name;
    }

    public void setName(EPriority name) {
        this.name = name;
    }
}
