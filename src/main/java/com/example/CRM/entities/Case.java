package com.example.CRM.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String description;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "priority_table",
            joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "priority_id"))
    private Set<Priority> priorities=new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "case_type_table",
            joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "casetype_id"))
    private Set<CaseType> caseTypes=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
