package com.example.CRM.dto.response;

import com.example.CRM.entities.ECampaignStatus;
import com.example.CRM.entities.ECampaignType;
import com.example.CRM.entities.Product;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignResponse {
    private Long id;
    private String name;
    private String description;
    private Date startdate;
    private Date enddate;
    private Double expectedrevenue;
    private Double budget;
    private Double actualcost;
    private Integer employeenumber;
    private Integer expectedresponse;
    @Enumerated(EnumType.STRING)
    private ECampaignStatus status;
    @Enumerated(EnumType.STRING)
    private ECampaignType type;
    private Product productObject;
    private Date createdat;
    private Date updatedat;


}
