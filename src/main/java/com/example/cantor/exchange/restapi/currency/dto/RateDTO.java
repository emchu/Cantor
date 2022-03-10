package com.example.cantor.exchange.restapi.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;


@JsonPropertyOrder({ "no", "effectiveDate", "mid" })
public class RateDTO {

    @Getter
    @JsonProperty("no")
    private String number;

    @Getter
    @JsonProperty("effectiveDate")
    private LocalDate date;

    @Getter
    @JsonProperty("mid")
    private BigDecimal mid;
}
