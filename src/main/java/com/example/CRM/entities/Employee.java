package com.example.CRM.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Employee extends User{
    private String rank;
    private Double salary;




}
