package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contact().isContactPresent()){
            app.contact().createContact(new ContactData("", "user", "user", "src/test/resources/images/avatar.png", "123"));
        }
        var oldContacts = app.contact().getList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contact().removeContact(oldContacts.get(index));
        var newContacts = app.contact().getList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    void canRemoveAllContactAtOnce() {
        if (app.contact().getCount() == 0) {
            app.contact().createContact(new ContactData());
        }
        app.contact().removeAllContact();
        Assertions.assertEquals(0, app.contact().getCount());
    }

}
