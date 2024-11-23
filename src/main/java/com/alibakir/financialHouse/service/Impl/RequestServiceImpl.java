package com.alibakir.financialHouse.service.Impl;

import com.alibakir.financialHouse.domain.Dto.*;
import com.alibakir.financialHouse.service.RequestService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    private final RestTemplate restTemplate;

    @Value("${api.client.url}")
    private String clientApiUrl;

    @Value("${api.transactions.report.url}")
    private String reportUrl;

    @Value("${api.transactions.list.url}")
    private String transactionListUrl;

    @Value("${api.transaction.url}")
    private String transactionUrl;

    public RequestServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ClientDto getClient(String token, String transactionId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", token);

            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("transactionId", transactionId);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<ClientDto> response = restTemplate.exchange(
                    clientApiUrl,
                    HttpMethod.POST,
                    requestEntity,
                    ClientDto.class
            );

            return Optional.ofNullable(response.getBody())
                    .orElseThrow(() -> new RuntimeException("Response body is null"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error occurred while fetching client data: " + e.getMessage());
        }
    }

    @Override
    public ReportDto getTransactionReport(String token, ReportRequestDto requestDto) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", token);

            HttpEntity<ReportRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);

            ResponseEntity<ReportDto> response = restTemplate.exchange(
                    reportUrl,
                    HttpMethod.POST,
                    requestEntity,
                    ReportDto.class
            );

            return Optional.ofNullable(response.getBody())
                    .orElseThrow(() -> new RuntimeException("Response body is null"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch transaction report: " + e.getMessage());
        }
    }

    @Override
    public TransactionResponseDto getTransactionList(String token, ReportRequestDto requestDto) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", token);


            HttpEntity<ReportRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);


            ResponseEntity<TransactionResponseDto> response = restTemplate.exchange(
                    transactionListUrl,
                    HttpMethod.POST,
                    requestEntity,
                    TransactionResponseDto.class
            );


            return Optional.ofNullable(response.getBody())
                    .orElseThrow(() -> new RuntimeException("Response body is null"));


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch transaction list: " + e.getMessage());
        }
    }

    @Override
    public GeneralTransactionResponseDto getTransactions(String token, String transactionId) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", token);

            TransactionRequestDto requestDto = new TransactionRequestDto();
            requestDto.setTransactionId(transactionId);

            HttpEntity<TransactionRequestDto> requestEntity = new HttpEntity<>(requestDto, headers);

            ResponseEntity<GeneralTransactionResponseDto> response = restTemplate.exchange(
                    transactionUrl,
                    HttpMethod.POST,
                    requestEntity,
                    GeneralTransactionResponseDto.class
            );

            return Optional.ofNullable(response.getBody())
                    .orElseThrow(() -> new RuntimeException("Response body is null"));

        } catch (HttpServerErrorException e) {
            System.err.println("Server Error Response Body: " + e.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch transaction details: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch transaction details: " + e.getMessage());
        }

    }
}
