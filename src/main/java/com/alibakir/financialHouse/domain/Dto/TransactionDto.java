package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionDto {

    @JsonProperty("merchant")
    private TransactionMerchantDto merchant;
}