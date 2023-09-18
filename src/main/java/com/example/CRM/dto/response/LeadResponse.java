package com.example.CRM.dto.response;

import com.example.CRM.entities.ELeadStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadResponse {
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
    private UserResponseDTO user = new UserResponseDTO();
    private Date createdat;
    private Date updatedat;
}
