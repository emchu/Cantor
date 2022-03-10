package com.example.cantor.exchange.restapi.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@JsonPropertyOrder({ "no", "effectiveDate", "mid" })
public class RateDTO {

    @Getter
    @JsonProperty("no")
    private String number;

    @Getter
    @JsonProperty("effectiveDate")
    private LocalDate date;

    @Getter
    @JsonProperty("mid")
    private BigDecimal mid;

    public RateDTO() {
    }

    public RateDTO(String number, LocalDate date, BigDecimal mid) {
        this.number = number;
        this.date = date;
        this.mid = mid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateDTO rateDTO = (RateDTO) o;
        return Objects.equals(number, rateDTO.number) && Objects.equals(date, rateDTO.date) && Objects.equals(mid, rateDTO.mid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, mid);
    }
}
