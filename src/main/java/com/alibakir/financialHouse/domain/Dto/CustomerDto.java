package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDto {
    @JsonProperty("number")
    private String number;

    @JsonProperty("email")
    private String email;

    @JsonProperty("billingFirstName")
    private String billingFirstName;

    @JsonProperty("billingLastName")
    private String billingLastName;
}

