package by.vadarod.test.samtsov.exrates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "exchangeRate")
public class ExchangeRate {
    @EmbeddedId
    private ExchangeRateId id;

    @Column(name = "official_rate")
    @JsonProperty("Cur_OfficialRate")
    private double rate;

    @Column(name = "scale")
    @JsonProperty("Cur_Scale")
    private double currencyScale;

    public ExchangeRate() {
    }

    public ExchangeRate(ExchangeRateId id, double rate, double currencyScale) {
        this.id = id;
        this.rate = rate;
        this.currencyScale = currencyScale;
    }

    public ExchangeRate(LocalDate date, String code, double rate,
                        double currencyScale) {

        this.id = new ExchangeRateId(code, date);
        this.rate = rate;
        this.currencyScale = currencyScale;
    }

    public ExchangeRateId getId() {
        return id;
    }

    public void setId(ExchangeRateId id) {
        this.id = id;
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getCurrencyScale() {
        return currencyScale;
    }

    public void setCurrencyScale(double currencyScale) {
        this.currencyScale = currencyScale;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExchangeRate{");
        sb.append("id=").append(id);
        sb.append(", rate=").append(rate);
        sb.append(", currencyScale=").append(currencyScale);
        sb.append('}');
        return sb.toString();
    }
}
