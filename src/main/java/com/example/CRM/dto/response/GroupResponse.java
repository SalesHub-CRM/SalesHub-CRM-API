package com.example.CRM.dto.response;

import com.example.CRM.entities.Client;
import com.example.CRM.entities.Lead;
import com.example.CRM.entities.Opportunity;
import com.example.CRM.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponse {
    private Long id;
    private String name;
    private Date createdat;
    private Date updatedat;
    private UserResponseDTO admin;
    private List<UserResponseDTO>employees=new ArrayList<>();
    private List<Lead> leads = new ArrayList<>();
    private List<Client>clients=new ArrayList<>();
    private List<Task>tasks=new ArrayList<>();

}
