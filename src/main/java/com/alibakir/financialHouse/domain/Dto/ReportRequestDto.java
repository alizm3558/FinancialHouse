package com.alibakir.financialHouse.domain.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequestDto {

    @NotBlank(message = "fromDate is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "fromDate must be in the format YYYY-MM-DD")
    @Schema(description = "Format: YYYY-MM-DD", example = "2015-01-01")
    private String fromDate;

    @NotBlank(message = "toDate is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "toDate must be in the format YYYY-MM-DD")
    @Schema(description = "Format: YYYY-MM-DD", example = "2024-01-01")
    private String toDate;
}