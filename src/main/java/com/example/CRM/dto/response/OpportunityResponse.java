package com.example.CRM.dto.response;

import com.example.CRM.entities.EOpportunityStage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpportunityResponse {
    private Long id;
    private String name;
    private Date closedate;
    private Double amount;
    private Integer probability;
    @Enumerated(EnumType.STRING)
    private EOpportunityStage stage;
    private UserResponseDTO employee = new UserResponseDTO();
    private Date createdat;
    private Date updatedat;
}
