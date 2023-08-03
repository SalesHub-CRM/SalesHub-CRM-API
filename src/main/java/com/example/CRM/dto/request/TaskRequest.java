package com.example.CRM.dto.request;

import com.example.CRM.entities.EPriority;
import com.example.CRM.entities.ETaskStatus;
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
public class TaskRequest {
    private String subject;
    private String comment;
    private String assignedto;
    private Date duedate;
    @Enumerated(EnumType.STRING)
    private ETaskStatus status;
    @Enumerated(EnumType.STRING)
    private EPriority priority;
    private Long groupId;
    private Long employeeId;
}
