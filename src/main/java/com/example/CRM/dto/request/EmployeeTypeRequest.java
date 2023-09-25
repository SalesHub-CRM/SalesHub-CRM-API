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
public class EmployeeTypeRequest {
    @Enumerated(EnumType.STRING)
    private EClientType type;
    private Long employeeId;
}
