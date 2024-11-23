package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IpnMerchantDto {

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("referenceNo")
    private String referenceNo;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("date")
    private long date;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("operation")
    private String operation;

    @JsonProperty("type")
    private String type;

    @JsonProperty("status")
    private String status;

    @JsonProperty("customData")
    private String customData;

    @JsonProperty("chainId")
    private String chainId;

    @JsonProperty("paymentType")
    private String paymentType;

    @JsonProperty("token")
    private String token;

    @JsonProperty("convertedAmount")
    private double convertedAmount;

    @JsonProperty("convertedCurrency")
    private String convertedCurrency;

    @JsonProperty("IPNUrl")
    private String ipnUrl;

    @JsonProperty("ipnType")
    private String ipnType;
}