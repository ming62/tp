package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPANY_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COMPANY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.application.Application;

/**
 * A utility class containing a list of {@code Application} objects to be used in tests.
 */
public class TypicalApplications {

    public static final Application ALICE = new ApplicationBuilder().withCompany("Accenture")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withRole("Software Engineer")
            .withTags("friends").build();
    public static final Application BENSON = new ApplicationBuilder().withCompany("Meta")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withRole("Data Analyst")
            .withTags("owesMoney", "friends").build();
    public static final Application CARL = new ApplicationBuilder().withCompany("Google").withRole("Mobile Developer")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Application DANIEL = new ApplicationBuilder().withCompany("Dyson").withRole("Backend Developer")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Application ELLE = new ApplicationBuilder().withCompany("Tencent").withRole("UX Designer")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Application FIONA = new ApplicationBuilder().withCompany("Foodpanda")
            .withRole("Frontend Developer")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Application GEORGE = new ApplicationBuilder().withCompany("Grab").withRole("DevOps Engineer")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Application HOON = new ApplicationBuilder().withCompany("HP").withRole("ML Engineer")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Application IDA = new ApplicationBuilder().withCompany("IBM").withRole("Systems Analyst")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Application's details found in {@code CommandTestUtil}
    public static final Application AMY = new ApplicationBuilder().withCompany(VALID_COMPANY_AMY)
            .withRole(VALID_ROLE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Application BOB = new ApplicationBuilder().withCompany(VALID_COMPANY_BOB)
            .withRole(VALID_ROLE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalApplications() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical applications.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Application application : getTypicalApplications()) {
            ab.addApplication(application);
        }
        return ab;
    }

    public static List<Application> getTypicalApplications() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
