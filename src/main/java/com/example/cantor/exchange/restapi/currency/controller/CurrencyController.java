package com.example.cantor.exchange.restapi.currency.controller;

import com.example.cantor.exeption.handler.ControllerExceptionHandler;
import com.example.cantor.exchange.restapi.currency.model.CurrencyRate;
import com.example.cantor.exeption.NBPResponseException;
import com.example.cantor.exchange.restapi.currency.service.CurrencyExchangeRateService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class CurrencyController extends ControllerExceptionHandler {

    @Autowired
    private CurrencyExchangeRateService currencyExchangeRateService;

    @GetMapping("/api/exchange-rates/{currencyCode}")
    public CurrencyRate getCurrencyExchangeRates(@PathVariable String currencyCode) throws IOException, NBPResponseException {
        return currencyExchangeRateService.getCurrencyExchangeRates(currencyCode);
    }

    @Getter
    String errorMessage = "Currency exchange rate not found";
}
