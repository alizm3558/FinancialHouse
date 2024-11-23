package com.alibakir.financialHouse.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TransactionResponseDto {

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("data")
    private List<TransactionDataDto> data;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    @JsonProperty("from")
    private int from;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("path")
    private String path;

    @JsonProperty("per_page")
    private int perPage;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    @JsonProperty("to")
    private int to;
}
