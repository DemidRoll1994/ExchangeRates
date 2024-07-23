package by.vadarod.test.samtsov.exrates.controller;

import by.vadarod.test.samtsov.exrates.mapper.ExchangeRateMapper;
import by.vadarod.test.samtsov.exrates.dto.NbrbApiDto;
import by.vadarod.test.samtsov.exrates.model.BaseResponse;
import by.vadarod.test.samtsov.exrates.repo.ExRatesRepository;
import by.vadarod.test.samtsov.exrates.validator.ParamsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class UpdateExRatesController {


    private static final String SUCCESS_STATUS = "success";
    private static final String BAD_REQUEST_STATUS = "Bad Request";
    private static final String ERROR_STATUS = "Internal Server Error";
    private static final int UPLOADED_CODE = 201;
    private static final int BAD_REQUEST_CODE = 400;
    private static final int INTERNAL_ERROR_CODE= 500;
    @Autowired
    private ExRatesRepository exRatesRepository;

    @GetMapping("/update")
    public BaseResponse showStatus(@RequestParam String date,
                                   NbrbApiController exchange) {
        Optional<LocalDate> localDate = ParamsValidator.validateDate(date);
        List<NbrbApiDto> currenciesOnDate;
        if (localDate.isPresent()) {
            currenciesOnDate = exchange.onDate(localDate.get());
            if (currenciesOnDate != null && !currenciesOnDate.isEmpty()) {
                exRatesRepository.saveAll(ExchangeRateMapper.toExchangeRate(currenciesOnDate));
                return new BaseResponse(SUCCESS_STATUS, UPLOADED_CODE);
            }
        } else {
            return new BaseResponse(BAD_REQUEST_STATUS, BAD_REQUEST_CODE);
        }
        return new BaseResponse(ERROR_STATUS, INTERNAL_ERROR_CODE);
    }
}
