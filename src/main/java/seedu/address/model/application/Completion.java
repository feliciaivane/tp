package seedu.address.model.application;

import static java.util.Objects.requireNonNull;

/**
 * Represents an Application's completion status in InternSHIP.
 * ADD THE GUARANTEE LATER
 */
public class Completion {
    public final String value;

    /**
     * Constructs a {@code Completion}.
     *
     * @param status A valid completion status.
     */
    public Completion(String status) {
        requireNonNull(status);
        value = status;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Completion
                && value.equals(((Completion) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}