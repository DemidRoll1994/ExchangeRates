package by.vadarod.test.samtsov.exrates.repo;

import by.vadarod.test.samtsov.exrates.model.ExchangeRate;
import by.vadarod.test.samtsov.exrates.model.ExchangeRateId;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ExRatesRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findById(ExchangeRateId exchangeRateId);

}
