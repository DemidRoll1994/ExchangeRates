package by.vadarod.test.samtsov.exrates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record NbrbApiDto(
        @JsonProperty("Cur_ID")
        long currencyId,
        @JsonProperty("Date")
        LocalDate date,
        @JsonProperty("Cur_Abbreviation")
        String abbreviation,
        @JsonProperty("Cur_Scale")
        double scale,
        @JsonProperty("Cur_Name")
        String name,
        @JsonProperty("Cur_OfficialRate")
        double officialRate) {
}
