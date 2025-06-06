package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var first_name : List.of("","user")) {
            for (var last_name : List.of("", "user")) {
                for (var fax : List.of("", "123")) {
                    result.add(new ContactData("", first_name, last_name,"src/test/resources/images/avatar.png", fax));

                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData("", randomString(i * 10), randomString(i * 10),randomFile("src/test/resources/images"), randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withPhoto("").withFax(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }


    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>((List.of(new ContactData("", "user'","","src/test/resources/images/avatar.png",""))));

        return result;
    }


    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContact(ContactData contact) {
        var oldContacts = app.contact().getList();
        app.contact().createContact(contact);
        var newContacts = app.contact().getList();
        Assertions.assertEquals(newContacts, oldContacts);

    }
}



