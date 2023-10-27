package com.example.CRM.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientStats {
    private int totalClients;
    private int clientsThisMonth;
    private int difference;

    public ClientStats (int totalClients,int clientsThisMonth,int difference){
        this.totalClients=totalClients;
        this.clientsThisMonth=clientsThisMonth;
        this.difference=difference;
    }
}
