package com.example.cantor.exchange.restapi.currency.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rate {

    @Getter
    private LocalDate date;

    @Getter
    private BigDecimal rate;

    public Rate(LocalDate date, BigDecimal rate) {
        this.date = date;
        this.rate = rate;
    }
}
