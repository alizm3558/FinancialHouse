package com.alibakir.financialHouse.controller;


import com.alibakir.financialHouse.domain.Dto.*;
import com.alibakir.financialHouse.service.AuthService;
import com.alibakir.financialHouse.service.RequestService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class TransactionReportController {

    private final RestTemplate restTemplate;

    private final AuthService authService;

    private final RequestService requestService;

    @Value("${api.report.url}")
    private String reportUrl;

    @Value("${api.client.url}")
    private String clientApiUrl;

    public TransactionReportController(RestTemplate restTemplate, AuthService authService, RequestService requestService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
        this.requestService= requestService;
    }



    @PostMapping("/client")
    public ResponseEntity<ClientDto> getClient(@Valid @RequestBody TransactionRequestDto requestDto) {
        try {
            String token = authService.getValidToken();

            ClientDto clientDto = requestService.getClient(token, requestDto.getTransactionId());

            return ResponseEntity.ok(clientDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/transactions/report")
    public ResponseEntity<ReportDto> getTransactionReport(@Valid @RequestBody ReportRequestDto requestDto) {
        try {

            String token = authService.getValidToken();

            ReportDto reportDto = requestService.getTransactionReport(token, requestDto);

            return ResponseEntity.ok(reportDto);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/transactions/list")
    public ResponseEntity<TransactionResponseDto> getTransactionList(
            @Valid @RequestBody ReportRequestDto requestDto) {
        try {
            String token = authService.getValidToken();

            TransactionResponseDto transactionResponseDto = requestService.getTransactionList(token, requestDto);

            return ResponseEntity.ok(transactionResponseDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<GeneralTransactionResponseDto> getTransaction(@Valid @RequestBody TransactionRequestDto requestDto) {
        try {
            String token = authService.getValidToken();

            GeneralTransactionResponseDto transactionDto = requestService.getTransactions(token, requestDto.getTransactionId());

            return ResponseEntity.ok(transactionDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}