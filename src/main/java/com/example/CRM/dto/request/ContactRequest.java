package com.example.CRM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private String salutation;
    private String firstname;
    private String lastname;
    private String title;
    private String email;
    private Long phone;
    private String address;
    private String address2;
    private String city;
    private Long zipcode;
    private Long clientId;
}
