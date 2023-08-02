package com.example.CRM.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
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
    private Date createdat;
    private Date updatedat;


    public CampaignResponse(Long id, String name, String description, Date startdate, Date enddate, Double expectedrevenue, Double budget, Double actualcost, Integer employeenumber, Integer expectedresponse, Date createdat, Date updatedat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.expectedrevenue = expectedrevenue;
        this.budget = budget;
        this.actualcost = actualcost;
        this.employeenumber = employeenumber;
        this.expectedresponse = expectedresponse;
        this.createdat = createdat;
        this.updatedat = updatedat;

    }
}
