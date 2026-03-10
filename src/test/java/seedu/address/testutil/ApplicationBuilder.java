package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.application.Address;
import seedu.address.model.application.Application;
import seedu.address.model.application.Company;
import seedu.address.model.application.Email;
import seedu.address.model.application.Role;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Application objects.
 */
public class ApplicationBuilder {

    public static final String DEFAULT_COMPANY = "Amazon";
    public static final String DEFAULT_ROLE = "Software Engineer Intern";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Company company;
    private Role role;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    /**
     * Creates a {@code ApplicationBuilder} with the default details.
     */
    public ApplicationBuilder() {
        company = new Company(DEFAULT_COMPANY);
        role = new Role(DEFAULT_ROLE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the ApplicationBuilder with the data of {@code applicationToCopy}.
     */
    public ApplicationBuilder(Application applicationToCopy) {
        company = applicationToCopy.getCompany();
        role = applicationToCopy.getRole();
        email = applicationToCopy.getEmail();
        address = applicationToCopy.getAddress();
        tags = new HashSet<>(applicationToCopy.getTags());
    }

    /**
     * Sets the {@code Company} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withCompany(String company) {
        this.company = new Company(company);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Application} that we are building.
     */
    public ApplicationBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Role} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withRole(String role) {
        this.role = new Role(role);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Application} that we are building.
     */
    public ApplicationBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Application build() {
        return new Application(company, role, email, address, tags);
    }

}
