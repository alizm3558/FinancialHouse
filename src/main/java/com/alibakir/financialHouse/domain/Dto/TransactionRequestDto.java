package com.alibakir.financialHouse.domain.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDto {

    @NotBlank(message = "Transaction ID is required")
    private String transactionId;
}
