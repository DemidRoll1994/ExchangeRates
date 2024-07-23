package by.vadarod.test.samtsov.exrates.controller;

import by.vadarod.test.samtsov.exrates.model.BaseResponse;
import by.vadarod.test.samtsov.exrates.model.ExchangeRateId;
import by.vadarod.test.samtsov.exrates.repo.ExRatesRepository;
import by.vadarod.test.samtsov.exrates.validator.ParamsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;


@RestController
public class ShowExRatesController {

    private static final String NO_INFO_MESSAGE
            = "No info about that date and currency code";

    private static final String EXCHANGE_RATE_PATTERN_MESSAGE
            = "Exchange rate is %f %s = %f BYN";
    private static final String BAD_REQUEST_STATUS = "Bad Request";


    private static final int NO_INFO_CODE = 404;
    private static final int OK_CODE = 200;
    private static final int BAD_REQUEST_CODE = 400;

    @Autowired
    private ExRatesRepository exRatesRepository;


    @GetMapping("/show")
    public BaseResponse showStatus2(@RequestParam String date,
                                    @RequestParam String currency_code) {
        Optional<LocalDate> localDate = ParamsValidator.validateDate(date);
        if (localDate.isPresent()) {
            var exchangeRate = exRatesRepository.findById(new ExchangeRateId(
                    currency_code, localDate.get()));
            if (exchangeRate != null) {
                return new BaseResponse(
                        String.format(EXCHANGE_RATE_PATTERN_MESSAGE,
                                exchangeRate.getCurrencyScale(),
                                currency_code,
                                exchangeRate.getRate()
                        ), OK_CODE);
            } else {
                return new BaseResponse(NO_INFO_MESSAGE, NO_INFO_CODE);
            }
        } else {
            return new BaseResponse(BAD_REQUEST_STATUS, BAD_REQUEST_CODE);
        }
    }

}
