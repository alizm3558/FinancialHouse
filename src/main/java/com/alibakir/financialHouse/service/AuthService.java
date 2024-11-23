package com.alibakir.financialHouse.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final RestTemplate restTemplate;

    @Value("${api.login.url}")
    private String loginUrl;

    @Value("${api.login.email}")
    private String loginEmail;

    @Value("${api.login.password}")
    private String loginPassword;

    @Value("${api.token.expiry.seconds}")
    private long tokenExpirySeconds;
    private String token;
    private Instant tokenExpiry;

    public AuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getValidToken() {

        if (token != null && tokenExpiry != null && tokenExpiry.isAfter(Instant.now())) {
            return token;
        }
        return refreshToken();
    }

    private String refreshToken() {

        Map<String, String> loginBody = new HashMap<>();
        loginBody.put("email", loginEmail);
        loginBody.put("password", loginPassword);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(loginBody, headers);

        try {

            ResponseEntity<Map> response = restTemplate.exchange(
                    loginUrl,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );


            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                token = (String) response.getBody().get("token");

                tokenExpiry = Instant.now().plusSeconds(tokenExpirySeconds);
                return token;
            }
        } catch (Exception e) {
            System.out.println("Error during token retrieval: " + e.getMessage());
        }

        throw new RuntimeException("Failed to retrieve token");
    }
}
