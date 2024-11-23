package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeneralTransactionResponseDto {

    @JsonProperty("customerInfo")
    private CustomerDto customerInfo;

    @JsonProperty("fx")
    private FxDto fx;

    @JsonProperty("transaction")
    private TransactionDto transaction;

    @JsonProperty("merchant")
    private MerchantDto merchant;
}
