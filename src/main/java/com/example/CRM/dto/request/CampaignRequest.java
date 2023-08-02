package com.example.CRM.dto.request;

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
    private Date createdat;
    private Date updatedat;

}
