package com.example.CRM.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Employee extends User{
    private String rank;
    private Double salary;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lead> leads;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Opportunity> opportunities;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;


}
