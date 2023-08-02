package com.example.CRM.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Administrator extends User{
    private Boolean confirmaccount; // account confirmation with mailer api

    @JsonManagedReference
    @OneToMany(mappedBy = "administrator",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Group>groups;

}
