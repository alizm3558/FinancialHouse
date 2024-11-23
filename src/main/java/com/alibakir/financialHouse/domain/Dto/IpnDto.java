package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IpnDto {

    @JsonProperty("sent")
    private boolean sent;

    @JsonProperty("merchant")
    private IpnMerchantDto merchant;
}
