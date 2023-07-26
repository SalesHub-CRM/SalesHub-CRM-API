package com.example.CRM.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String salutation;
    private String firstname;
    private String lastname;
    private String title;
    private String email;
    private Long phone;
    private String address;
    private String address2;
    private String city;
    private Long zipcode;
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
