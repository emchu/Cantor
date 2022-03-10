package com.example.cantor.exchange.restapi.gold.controller;

import com.example.cantor.exeption.handler.ControllerExceptionHandler;
import com.example.cantor.exeption.NBPResponseException;
import com.example.cantor.exchange.restapi.gold.model.GoldAverageExchangeRate;
import com.example.cantor.exchange.restapi.gold.service.GoldExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class CantorController extends ControllerExceptionHandler {

    @Autowired
    private GoldExchangeService goldExchangeService;

    @GetMapping("/api/gold-price/average")
    public GoldAverageExchangeRate getProductById() throws IOException, NBPResponseException {

        return goldExchangeService.getGoldExchangeRates();
    }

    String errorMessage = "Gold exchange rate not found";
}
