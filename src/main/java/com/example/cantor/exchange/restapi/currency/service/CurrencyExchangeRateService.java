package com.example.cantor.exchange.restapi.currency.service;

import com.example.cantor.api.connector.NBPApiConnector;
import com.example.cantor.mapper.URLObjectMapper;
import com.example.cantor.exchange.restapi.currency.dto.CurrencyExchangeRateDTO;
import com.example.cantor.exchange.restapi.currency.model.Rate;
import com.example.cantor.exeption.NBPResponseException;
import com.example.cantor.exchange.restapi.currency.model.CurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;


@Service
public class CurrencyExchangeRateService {
    @Value("${currencyExchangeRate.url}")
    private String urlToBuild;

    @Autowired
    private NBPApiConnector nbpApiConnector;

    @Autowired
    private URLObjectMapper urlObjectMapper;

    public CurrencyRate getCurrencyExchangeRates(String currencyCode) throws IOException, NBPResponseException {
        URL url = new URL(urlToBuild.replace("{currency}",currencyCode));

        StringBuffer content = nbpApiConnector.getExchangeRates(url);
        CurrencyExchangeRateDTO currencyExchangeRateDTO = urlObjectMapper.mapCurrencyExchangeRateURL(content);

        return new CurrencyRate(
                        currencyExchangeRateDTO.getCurrency(),
                        currencyExchangeRateDTO.getCurrencyCode(),
                        currencyExchangeRateDTO.getCurrencyRates()
                                .stream()
                                .map(rateDTO -> new Rate(rateDTO.getDate(),rateDTO.getMid()))
                                .collect(Collectors.toList()));

    }
}
