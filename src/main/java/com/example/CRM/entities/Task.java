package com.example.CRM.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // private Employee assignedto;
    private Date duedate;
    @Enumerated(EnumType.STRING)
    private ETaskStatus status;
    @Enumerated(EnumType.STRING)
    private EPriority priority;
    private Long employeeId;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


}
