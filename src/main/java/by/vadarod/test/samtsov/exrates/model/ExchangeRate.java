package by.vadarod.test.samtsov.exrates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "exchangeRate")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    @JsonProperty("Cur_Abbreviation")
    private String currencyCode;

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "official_rate")
    @JsonProperty("Cur_OfficialRate")
    private double rate;

    @Column(name = "scale")
    @JsonProperty("Cur_Scale")
    private double currencyScale;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

}
