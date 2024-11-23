package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("allowPartialRefund")
    private boolean allowPartialRefund;

    @JsonProperty("allowPartialCapture")
    private boolean allowPartialCapture;
}
