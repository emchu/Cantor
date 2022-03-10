package com.example.cantor;

import com.example.cantor.exchange.restapi.currency.dto.CurrencyExchangeRateDTO;
import com.example.cantor.exchange.restapi.currency.dto.RateDTO;
import com.example.cantor.mapper.URLObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


@SpringBootTest
class CantorApplicationTests {

    @Test
    void jsonParserTest() throws JsonProcessingException {
        StringBuffer json = new StringBuffer("{\"table\":\"A\",\"currency\":\"frank szwajcarski\",\"code\":\"CHF\",\"rates\":[{\"no\":\"048/A/NBP/2022\",\"effectiveDate\":\"2022-03-10\",\"mid\":4.6917}]}");
        URLObjectMapper mapper = new URLObjectMapper();

        CurrencyExchangeRateDTO result = mapper.mapCurrencyExchangeRateURL(json);

        RateDTO expectedRateDTO = new RateDTO(
                "048/A/NBP/2022",
                LocalDate.parse("2022-03-10"),
                BigDecimal.valueOf(4.6917));

        CurrencyExchangeRateDTO expected = new CurrencyExchangeRateDTO(
                "A",
                "frank szwajcarski",
                "CHF",
                Collections.singletonList(expectedRateDTO));

        Assertions.assertEquals(result, expected);
    }
}
