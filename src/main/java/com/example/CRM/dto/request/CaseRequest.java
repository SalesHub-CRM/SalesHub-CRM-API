package com.example.CRM.dto.request;

import com.example.CRM.entities.ECaseType;
import com.example.CRM.entities.EPriority;
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
public class CaseRequest {
    private String subject;
    private String description;
    @Enumerated(EnumType.STRING)
    private ECaseType type;
    @Enumerated(EnumType.STRING)
    private EPriority priority;
    private Long clientId;
}
