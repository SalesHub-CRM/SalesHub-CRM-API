package com.example.CRM.dto.request;

import com.example.CRM.entities.EClientType;
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
public class ClientRequest {
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
    private Long employeeId;
    private Long campaignId;
}
