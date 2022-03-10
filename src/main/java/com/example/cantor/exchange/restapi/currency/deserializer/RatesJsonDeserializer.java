package com.example.cantor.exchange.restapi.currency.deserializer;

import com.example.cantor.exchange.restapi.currency.dto.RateDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;

public class RatesJsonDeserializer extends JsonDeserializer<List<RateDTO>> {

    @Override
    public List<RateDTO> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        RateDTO[] x = jp.readValueAs(RateDTO[].class);
        return List.of(x);
    }

}