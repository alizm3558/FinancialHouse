package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionMerchantDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("referenceNo")
    private String referenceNo;

    @JsonProperty("merchantId")
    private Long merchantId;

    @JsonProperty("fxTransactionId")
    private Long fxTransactionId;

    @JsonProperty("acquirerTransactionId")
    private Long acquirerTransactionId;

    @JsonProperty("chainId")
    private String chainId;

    @JsonProperty("agentInfoId")
    private Long agentInfoId;

    @JsonProperty("returnUrl")
    private String returnUrl;

    @JsonProperty("status")
    private String status;

    @JsonProperty("operation")
    private String operation;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("deleted_at")
    private String deletedAt;

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("customData")
    private String customData;

    @JsonProperty("parentId")
    private Long parentId;

    @JsonProperty("type")
    private String type;

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("agent")
    private TransactionAgentDto agent;
}