package com.example.cantor.exchange.restapi.currency.dto;

import com.example.cantor.exchange.restapi.currency.deserializer.RatesJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.List;


@JsonPropertyOrder({ "table", "currency", "code", "rates" })
public class CurrencyExchangeRateDTO {

    @Getter
    @JsonProperty("table")
    private String table;

    @Getter
    @JsonProperty("currency")
    private String currency;

    @Getter
    @JsonProperty("code")
    private String currencyCode;

    @Getter
    @JsonProperty("rates")
    @JsonDeserialize(using = RatesJsonDeserializer.class)
    private List<RateDTO> currencyRates;
}
