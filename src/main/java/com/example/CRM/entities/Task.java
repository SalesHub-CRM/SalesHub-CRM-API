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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String comment;
    private String assignedto; //hadhi fiha employé, badalha object
    private Date duedate;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "task_status",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "taskstatus_id"))
    private Set<TaskStatus> taskStatus= new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "leads_status",
            joinColumns = @JoinColumn(name = "lead_id"),
            inverseJoinColumns = @JoinColumn(name = "leadstatus_id"))
    private Set<Priority>priorities=new HashSet<>();

}
