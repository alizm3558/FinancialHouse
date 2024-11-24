package com.alibakir.financialHouse.controller;


import com.alibakir.financialHouse.domain.Dto.*;
import com.alibakir.financialHouse.service.AuthService;
import com.alibakir.financialHouse.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class TransactionReportController {

    private final RestTemplate restTemplate;

    private final AuthService authService;

    private final RequestService requestService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionReportController.class);

    @Value("${api.report.url}")
    private String reportUrl;

    @Value("${api.client.url}")
    private String clientApiUrl;

    public TransactionReportController(RestTemplate restTemplate, AuthService authService, RequestService requestService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
        this.requestService= requestService;
    }


    @Operation(summary ="https://sandbox-reporting.rpdpymnt.com/api/v3/client")
    @PostMapping("/client")
    public ResponseEntity<ClientDto> getClient(@Valid @RequestBody TransactionRequestDto requestDto, HttpServletRequest request) {
        try {
            String clientIp = request.getRemoteAddr();
            logger.info("Gelen isteğin IP adresi: {}", clientIp);
            String token = authService.getValidToken();

            ClientDto clientDto = requestService.getClient(token, requestDto.getTransactionId());

            return ResponseEntity.ok(clientDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary ="https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report")
    @PostMapping("/transactions/report")
    public ResponseEntity<ReportDto> getTransactionReport(@Valid @RequestBody ReportRequestDto requestDto, HttpServletRequest request) {
        try {
            String clientIp = request.getRemoteAddr();
            logger.info("Gelen isteğin IP adresi: {}", clientIp);

            String token = authService.getValidToken();

            ReportDto reportDto = requestService.getTransactionReport(token, requestDto);

            return ResponseEntity.ok(reportDto);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary ="https://sandbox-reporting.rpdpymnt.com/api/v3/transaction/list")
    @PostMapping("/transactions/list")
    public ResponseEntity<TransactionResponseDto> getTransactionList(
            @Valid @RequestBody ReportRequestDto requestDto, HttpServletRequest request) {
        try {
            String clientIp = request.getRemoteAddr();
            logger.info("Gelen isteğin IP adresi: {}", clientIp);
            String token = authService.getValidToken();

            TransactionResponseDto transactionResponseDto = requestService.getTransactionList(token, requestDto);

            return ResponseEntity.ok(transactionResponseDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary ="https://sandbox-reporting.rpdpymnt.com/api/v3/transaction")
    @PostMapping("/transaction")
    public ResponseEntity<GeneralTransactionResponseDto> getTransaction(@Valid @RequestBody TransactionRequestDto requestDto, HttpServletRequest request) {
        try {
            String clientIp = request.getRemoteAddr();
            logger.info("Gelen isteğin IP adresi: {}", clientIp);
            String token = authService.getValidToken();

            GeneralTransactionResponseDto transactionDto = requestService.getTransactions(token, requestDto.getTransactionId());

            return ResponseEntity.ok(transactionDto);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}