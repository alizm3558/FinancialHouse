package com.alibakir.financialHouse.domain.Dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDto {
    private long count;
    private long total;
    private String currency;
}
