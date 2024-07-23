package by.vadarod.test.samtsov.exrates.mapper;

import by.vadarod.test.samtsov.exrates.dto.NbrbApiDto;
import by.vadarod.test.samtsov.exrates.model.ExchangeRate;

import java.util.List;
import java.util.stream.Collectors;

public class ExchangeRateMapper {
    public static List<ExchangeRate> toExchangeRate(List<NbrbApiDto> dtos) {
        return dtos.stream()
                .map(nbrbApiDto -> new ExchangeRate(nbrbApiDto.date(),
                        nbrbApiDto.abbreviation(),nbrbApiDto.officialRate(),
                        nbrbApiDto.scale()))
                .collect(Collectors.toList());
    }
}
