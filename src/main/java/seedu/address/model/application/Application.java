package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents an Application in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Application {

    // Identity fields
    private final Company company;
    private final Role role;

    // Data fields
    private final Optional<Location> location;
    private final ApplicationDate applicationDate;
    private final Status status;
    private final Optional<Url> url;

    /**
     * Company, role, and location are required.
     * applicationDate and status default if not provided.
     * url is optional.
     */
    public Application(Company company, Role role, Optional<Location> location,
                       ApplicationDate applicationDate, Status status, Optional<Url> url) {
        requireAllNonNull(company, role, location, applicationDate, status);
        this.company = company;
        this.role = role;
        this.location = location == null ? Optional.empty() : location;
        this.applicationDate = applicationDate;
        this.status = status;
        this.url = url == null ? Optional.empty() : url;
    }

    public Company getCompany() {
        return company;
    }

    public Role getRole() {
        return role;
    }

    public Optional<Location> getLocation() {
        return location;
    }

    public ApplicationDate getApplicationDate() {
        return applicationDate;
    }

    public Status getStatus() {
        return status;
    }

    public Optional<Url> getUrl() {
        return url;
    }

    /**
     * Returns true if both applications have the same company name and role.
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
                && location.equals(otherApplication.location)
                && applicationDate.equals(otherApplication.applicationDate)
                && status.equals(otherApplication.status)
                && url.equals(otherApplication.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, role, location, applicationDate, status, url);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("company", company)
                .add("role", role)
                .add("location", location)
                .add("applicationDate", applicationDate)
                .add("status", status)
                .add("url", url.map(Object::toString).orElse(""))
                .toString();
    }

}
