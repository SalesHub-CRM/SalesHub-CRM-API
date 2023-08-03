package com.example.CRM.dto.request;

import com.example.CRM.entities.ECampaignStatus;
import com.example.CRM.entities.ECampaignType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CampaignRequest {
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
    private ECampaignType type;
    @Enumerated(EnumType.STRING)
    private ECampaignStatus status;
    private Long productId;


}
