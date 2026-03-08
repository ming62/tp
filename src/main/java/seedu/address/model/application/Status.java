package seedu.address.model.application;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Application's status in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStatus(String)}
 */
public class Status {

    public static final String MESSAGE_CONSTRAINTS =
            "Status should be one of: Applied, Interview, Offered, Rejected";

    public static final String DEFAULT_VALUE = "Applied";

    public final String value;

    /**
     * Constructs a {@code Status}.
     *
     * @param status A valid status string.
     */
    public Status(String status) {
        requireNonNull(status);
        checkArgument(isValidStatus(status), MESSAGE_CONSTRAINTS);
        value = status;
    }

    /**
     * Returns a Status with the default value "Applied".
     */
    public static Status getDefault() {
        return new Status(DEFAULT_VALUE);
    }

    /**
     * Returns true if a given string is a valid status.
     */
    public static boolean isValidStatus(String test) {
        return test.equals("Applied") || test.equals("Interview")
                || test.equals("Offered") || test.equals("Rejected");
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

        if (!(other instanceof Status)) {
            return false;
        }

        Status otherStatus = (Status) other;
        return value.equals(otherStatus.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
