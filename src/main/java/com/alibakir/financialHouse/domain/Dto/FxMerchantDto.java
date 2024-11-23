package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FxMerchantDto {

    @JsonProperty("originalAmount")
    private double originalAmount;

    @JsonProperty("originalCurrency")
    private String originalCurrency;

    @JsonProperty("convertedAmount")
    private double convertedAmount;

    @JsonProperty("convertedCurrency")
    private String convertedCurrency;
}
