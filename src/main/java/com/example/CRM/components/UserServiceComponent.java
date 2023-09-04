package com.example.CRM.components;

import com.example.CRM.dto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class UserServiceComponent {
    @Autowired
    private RestTemplate restTemplate;

    public UserResponseDTO fetchUserById(Long userId)
    {
        return restTemplate.getForObject("http://AUTH-SERVICE/auth/getUser/"+userId, UserResponseDTO.class);
    }


    public List<UserResponseDTO> listUsersByGroupId(Long groupId) {
        ResponseEntity<List<UserResponseDTO>> responseEntity = restTemplate.exchange(
                "http://AUTH-SERVICE/auth/listByGroupId/" + groupId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserResponseDTO>>() {}
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Handle error or return an empty list
            return Collections.emptyList();
        }
    }
}
