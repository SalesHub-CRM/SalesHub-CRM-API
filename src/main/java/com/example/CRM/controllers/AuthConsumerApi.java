package com.example.CRM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthConsumerApi {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> login() {
        String url = "http://localhost:8085:auth/signin"; // Replace with actual host and path
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok("Received from auth microservice: " + response.getBody());
    }
}
