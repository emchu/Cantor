package com.example.cantor.exchange.restapi.currency.model;

import lombok.Getter;

import java.util.List;


public class CurrencyRate {

    @Getter
    private String currency;

    @Getter
    private String currencyCode;

    @Getter
    private List<Rate> rates;

    public CurrencyRate(String currency, String currencyCode, List<Rate> rates) {
        this.currency = currency;
        this.currencyCode = currencyCode;
        this.rates = rates;
    }
}

