package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionDataDto {

    @JsonProperty("fx")
    private FxDto fx;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("acquirer")
    private AcquirerDto acquirer;

    @JsonProperty("transaction")
    private TransactionDto transaction;

    @JsonProperty("refundable")
    private boolean refundable;

    @JsonProperty("customerInfo")
    private CustomerDto customerInfo;

    @JsonProperty("merchant")
    private MerchantDto merchant;

    @JsonProperty("ipn")
    private IpnDto ipn;
}