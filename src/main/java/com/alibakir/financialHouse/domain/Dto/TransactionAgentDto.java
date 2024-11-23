package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionAgentDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("customerIp")
    private String customerIp;

    @JsonProperty("customerUserAgent")
    private String customerUserAgent;

    @JsonProperty("merchantIp")
    private String merchantIp;

    @JsonProperty("merchantUserAgent")
    private String merchantUserAgent;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("deleted_at")
    private String deletedAt;
}