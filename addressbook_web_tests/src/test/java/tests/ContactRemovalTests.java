package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData("name", "last name", "fax"));
        }
        int contactCount = app.contact().getCount();
        app.contact().removeContact();
        int newContactCount = app.contact().getCount();
        Assertions.assertEquals(contactCount - 1, newContactCount);
    }

    @Test
    void canRemoveAllContactAtOnce() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData("name", "last name", "fax"));
        }
        app.contact().removeAllContact();
        Assertions.assertEquals(0, app.contact().getCount());
    }

}
