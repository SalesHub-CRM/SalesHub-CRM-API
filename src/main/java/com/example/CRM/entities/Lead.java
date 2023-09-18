package com.example.CRM.entities;


import com.example.CRM.dto.response.UserResponseDTO;
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
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String salutation;
    private String firstname;
    private String lastname;
    private String title;
    private String company;
    private String email;
    private Long phone;
    private String address;
    private String city;
    private Long zipcode;
    private String source;
    private Integer employeenumber;
    private String industry;
    private Double annualrevenue;
    @Enumerated(EnumType.STRING)
    private ELeadStatus status;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    private Long employeeID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}
