package seedu.address.model.application;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an Application's date in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidApplicationDate(String)}
 */
public class ApplicationDate {

    public static final String MESSAGE_CONSTRAINTS =
            "Application dates should be in the format YYYY-MM-DD";

    public static final String VALIDATION_REGEX = "\\d{4}-\\d{2}-\\d{2}";

    public static final String DEFAULT_VALUE =
            LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

    public final String value;

    /**
     * Constructs an {@code ApplicationDate}.
     *
     * @param applicationDate A valid application date string.
     */
    public ApplicationDate(String applicationDate) {
        requireNonNull(applicationDate);
        checkArgument(isValidApplicationDate(applicationDate), MESSAGE_CONSTRAINTS);
        value = applicationDate;
    }

    /**
     * Returns an ApplicationDate with today's date as the default.
     */
    public static ApplicationDate getDefault() {
        return new ApplicationDate(DEFAULT_VALUE);
    }

    /**
     * Returns true if a given string is a valid application date.
     */
    public static boolean isValidApplicationDate(String test) {
        if (!test.matches(VALIDATION_REGEX)) {
            return false;
        }
        try {
            LocalDate.parse(test, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ApplicationDate)) {
            return false;
        }

        ApplicationDate otherDate = (ApplicationDate) other;
        return value.equals(otherDate.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
