package com.example.CRM.entities;

import jakarta.persistence.*;

@Entity
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column()
    private ETaskStatus name;

    public TaskStatus() {
    }

    public TaskStatus(ETaskStatus name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public ETaskStatus getName() {
        return name;
    }

    public void setName(ETaskStatus name) {
        this.name = name;
    }
}
