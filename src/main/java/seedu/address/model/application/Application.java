package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents an Application in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Application {

    // Identity fields
    private final Company company;
    private final Role role;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Application(Company company, Role role, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(company, role, email, address, tags);
        this.company = company;
        this.role = role;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
    }

    public Company getCompany() {
        return company;
    }

    public Role getRole() {
        return role;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both applications have the same company name.
     * This defines a weaker notion of equality between two applications.
     */
    public boolean isSameApplication(Application otherApplication) {
        if (otherApplication == this) {
            return true;
        }

        return otherApplication != null
                && otherApplication.getCompany().equals(getCompany())
                && otherApplication.getRole().equals(getRole());
    }

    /**
     * Returns true if both applications have the same identity and data fields.
     * This defines a stronger notion of equality between two applications.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Application)) {
            return false;
        }

        Application otherApplication = (Application) other;
        return company.equals(otherApplication.company)
                && role.equals(otherApplication.role)
                && email.equals(otherApplication.email)
                && address.equals(otherApplication.address)
                && tags.equals(otherApplication.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(company, role, email, address, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("company", company)
                .add("role", role)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .toString();
    }

}
