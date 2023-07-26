package com.example.CRM.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @CreationTimestamp
    private Date createdat;
    @UpdateTimestamp
    private Date updatedat;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "campaign_type_table",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "campaigntype_id"))
    private Set<CampaignType> campaignTypes=new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "campaign_status_table",
            joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "campaignstatus_id"))
    private Set<CampaignStatus> campaignStatusSet=new HashSet<>();


    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Client>clients;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
