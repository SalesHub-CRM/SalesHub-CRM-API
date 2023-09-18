package com.example.CRM.dto.request;

import com.example.CRM.entities.ELeadStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeadRequest {
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
    private Long employeeID;
    private Long groupId;
}
