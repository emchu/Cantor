package com.example.cantor.mapper;

import com.example.cantor.exchange.restapi.currency.dto.CurrencyExchangeRateDTO;
import com.example.cantor.exchange.restapi.gold.dto.GoldExchangeRateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("com.example.cantor.mapper.URLObjectMapper")
public class URLObjectMapper {

    ObjectMapper mapper;

    public URLObjectMapper() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public List<GoldExchangeRateDTO> mapGoldRateURL(StringBuffer content) throws JsonProcessingException {
        return mapper.readValue(String.valueOf(content), new TypeReference<>() {
        });
    }

    public CurrencyExchangeRateDTO mapCurrencyExchangeRateURL(StringBuffer content) throws JsonProcessingException {
        return mapper.readValue(String.valueOf(content), new TypeReference<>() {
        });
    }
}