package com.example.cantor.exchange.restapi.gold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@JsonPropertyOrder({ "data", "cena" })
public class GoldExchangeRateDTO {

    @Getter
    @JsonProperty("data")
    private Date date;

    @Getter
    @JsonProperty("cena")
    private BigDecimal exchangeRate;
}
