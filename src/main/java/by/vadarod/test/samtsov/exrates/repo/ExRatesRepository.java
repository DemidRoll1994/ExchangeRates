package by.vadarod.test.samtsov.exrates.repo;

import by.vadarod.test.samtsov.exrates.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ExRatesRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByDateAndCurrencyCode(LocalDate date,
                                           String currencyName);
}
