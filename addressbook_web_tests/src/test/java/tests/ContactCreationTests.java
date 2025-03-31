package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateNewContact() {
        app.contact().createContact(new ContactData("first name", "last name", "fax"));
    }

    @Test
    public void canCreateContactEmpty() {
        app.contact().createContact(new ContactData());
    }

    @Test
    public void canCreateContactWithOnly() {
        app.contact().createContact(new ContactData().withFirstName("unknown"));
    }
}



