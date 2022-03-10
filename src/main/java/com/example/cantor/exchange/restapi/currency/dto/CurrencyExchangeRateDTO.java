package com.example.cantor.exchange.restapi.currency.dto;

import com.example.cantor.exchange.restapi.currency.deserializer.RatesJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import java.util.List;
import java.util.Objects;


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

    public CurrencyExchangeRateDTO() {
    }

    public CurrencyExchangeRateDTO(String table, String currency, String currencyCode, List<RateDTO> currencyRates) {
        this.table = table;
        this.currency = currency;
        this.currencyCode = currencyCode;
        this.currencyRates = currencyRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchangeRateDTO that = (CurrencyExchangeRateDTO) o;
        return Objects.equals(table, that.table) && Objects.equals(currency, that.currency) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(currencyRates, that.currencyRates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, currency, currencyCode, currencyRates);
    }
}
