package com.alibakir.financialHouse.service;

import com.alibakir.financialHouse.domain.Dto.*;

public interface RequestService {

    public ClientDto getClient(String token, String transactionId);

    public ReportDto getTransactionReport(String token, ReportRequestDto requestDto);

    public TransactionResponseDto getTransactionList(String token, ReportRequestDto requestDto);

    public GeneralTransactionResponseDto getTransactions(String token, String transactionId);
}
