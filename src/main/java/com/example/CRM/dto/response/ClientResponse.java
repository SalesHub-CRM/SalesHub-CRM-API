package com.example.CRM.dto.response;

import com.example.CRM.entities.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private Long id;
    private String name;
    private String parentname;
    private Long phone;
    private Long fax;
    private String email;
    private String website;
    private Integer employeenumber;
    private Double annualrevenue;
    private String industry;
    private String billingaddress;
    private String shippingaddress;
    @Enumerated(EnumType.STRING)
    private EClientType type;
    private UserResponseDTO user = new UserResponseDTO();
    private List<Contact>contacts=new ArrayList<>();
    private List<Case>cases=new ArrayList<>();
    private List<Opportunity>opportunities=new ArrayList<>();
    private Date createdat;
    private Date updatedat;
}
