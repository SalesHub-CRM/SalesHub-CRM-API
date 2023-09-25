package com.example.CRM.dto.response;

import com.example.CRM.entities.EPriority;
import com.example.CRM.entities.ETaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {
    private Long id;
    private String subject;
    private String comment;
    private UserResponseDTO assignedto = new UserResponseDTO();
    private Date duedate;
    @Enumerated(EnumType.STRING)
    private ETaskStatus status;
    @Enumerated(EnumType.STRING)
    private EPriority priority;
    private UserResponseDTO employee = new UserResponseDTO();
    private Date createdat;
    private Date updatedat;
}
