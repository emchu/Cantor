package com.example.cantor.exchange.restapi.gold.service;

import com.example.cantor.api.connector.NBPApiConnector;
import com.example.cantor.mapper.URLObjectMapper;
import com.example.cantor.exeption.NBPResponseException;
import com.example.cantor.exchange.restapi.gold.dto.GoldExchangeRateDTO;
import com.example.cantor.exchange.restapi.gold.model.GoldAverageExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.List;
import java.util.Objects;


@Service
public class GoldExchangeService {
    @Value("${goldExchangeRate.url}")
    private URL url;

    @Autowired
    private NBPApiConnector nbpApiConnector;

    @Autowired
    private URLObjectMapper urlObjectMapper;

    public GoldAverageExchangeRate getGoldExchangeRates() throws IOException, NBPResponseException {
        StringBuffer content = nbpApiConnector.getExchangeRates(url);

        List<GoldExchangeRateDTO> goldExchangeRateDTOList = urlObjectMapper.mapGoldRateURL(content);

        BigDecimal average = goldExchangeRateDTOList.stream()
                .map(Objects::requireNonNull)
                .map(GoldExchangeRateDTO::getExchangeRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(goldExchangeRateDTOList.size()), 2, RoundingMode.HALF_EVEN);

        return new GoldAverageExchangeRate(average);
    }

}
