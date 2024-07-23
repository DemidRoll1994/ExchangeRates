package by.vadarod.test.samtsov.exrates.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class ExchangeRateId implements Serializable {
    @JsonProperty("code")
    @Column(name = "code")
    private String currencyCode;

    @JsonProperty("date")
    @Column(name = "date")
    private LocalDate date;

    public ExchangeRateId() {
    }

    public ExchangeRateId(String currencyCode, LocalDate date) {
        this.currencyCode = currencyCode;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeRateId that = (ExchangeRateId) o;

        if (!currencyCode.equals(that.currencyCode)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = currencyCode.hashCode();
        result = 31 * result + date.hashCode();
        return result;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExchangeRateId{");
        sb.append("currencyCode='").append(currencyCode).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }
}