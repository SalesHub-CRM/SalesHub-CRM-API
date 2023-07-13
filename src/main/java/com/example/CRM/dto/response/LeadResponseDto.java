package com.example.CRM.dto.response;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
public class LeadResponseDto {
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
    private Date createdat;
    private Date updatedat;
    private List<String> leadStatus;


}
