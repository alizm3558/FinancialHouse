package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FxDto {

    @JsonProperty("merchant")
    private FxMerchantDto merchant;
}