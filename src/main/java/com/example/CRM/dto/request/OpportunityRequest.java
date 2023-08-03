package com.example.CRM.dto.request;

import com.example.CRM.entities.EOpportunityStage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OpportunityRequest {
    private String name;
    private Date closedate;
    private Double amount;
    private Integer probability;
    @Enumerated(EnumType.STRING)
    private EOpportunityStage stage;
    private Long employeeId;
    private Long clientId;
}
