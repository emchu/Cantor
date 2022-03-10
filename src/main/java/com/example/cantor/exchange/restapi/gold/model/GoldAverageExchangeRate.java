package com.example.cantor.exchange.restapi.gold.model;

import lombok.Getter;

import java.math.BigDecimal;


public class GoldAverageExchangeRate {

    public GoldAverageExchangeRate(BigDecimal averageExchangeRate) {
        this.averageExchangeRate = averageExchangeRate;
    }

    @Getter
    private BigDecimal averageExchangeRate;
}
