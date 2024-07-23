package by.vadarod.test.samtsov.exrates.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class ParamsValidator {
    private static final LocalDate FIRST_DAY_OF_NBRB_WORKING =
            LocalDate.parse("1995-03-29", DateTimeFormatter.ISO_LOCAL_DATE);

    public static Optional<LocalDate> validateDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            if (date.isBefore(LocalDate.now()) && date.isAfter(FIRST_DAY_OF_NBRB_WORKING))
                return Optional.ofNullable(date);
            else
                return Optional.empty();
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }
}
