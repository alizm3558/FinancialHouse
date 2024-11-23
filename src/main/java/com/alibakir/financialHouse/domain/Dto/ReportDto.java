package com.alibakir.financialHouse.domain.Dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private String status;
    private List<ReportResponseDto> response;
}
