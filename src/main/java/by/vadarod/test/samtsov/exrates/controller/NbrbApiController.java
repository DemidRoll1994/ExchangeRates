package by.vadarod.test.samtsov.exrates.controller;

import by.vadarod.test.samtsov.exrates.model.ExchangeRate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class NbrbApiController {
    public List<ExchangeRate> onDate(LocalDate date) {
        RestTemplate restTemplate = new RestTemplate();
        ExchangeRate[] exRates = restTemplate.getForObject(String.format(
                "https://api.nbrb.by/exrates/rates?ondate=%s&periodicity=0",
                date.format(DateTimeFormatter.ISO_LOCAL_DATE)), ExchangeRate[].class);
        if (exRates == null) throw new AssertionError();
        return Arrays.stream(exRates).peek(rate->rate.setDate(date)).toList();
    }
}