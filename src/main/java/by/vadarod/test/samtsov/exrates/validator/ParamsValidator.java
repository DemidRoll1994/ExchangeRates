package by.vadarod.test.samtsov.exrates.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ParamsValidator {

    public static Optional<LocalDate> validateDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return Optional.ofNullable(date);
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }
}
