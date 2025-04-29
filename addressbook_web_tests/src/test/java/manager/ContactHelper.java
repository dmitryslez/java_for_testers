package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);

    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }
    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContact();
    }
    public void openContactPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("add new"));
        }
    }
    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("lastname"), contact.last_name());
        attach(By.name("photo"),contact.photo());
        type(By.name("fax"), contact.fax());

    }
    private void openHomePage() {
        click(By.linkText("home"));
    }
    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }


    private void selectContact(ContactData contact) {
        click(By.xpath(String.format("//a[contains(@href,'edit') and contains(@href,'%s')]", contact.id())));
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }
    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();

    }
    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs){
            var last_td = tr.findElement(By.cssSelector("td:nth-child(2)"));
            var last_name = last_td.getText();
            var first_td = tr.findElement(By.cssSelector("td:nth-child(3)"));
            var first_name = first_td.getText();
            var id_td = tr.findElement(By.cssSelector("td.center"));
            var checkbox = id_td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(first_name).withLastName(last_name));
        }
        return contacts;
    }


    public void removeAllContact() {
        openHomePage();
        selectAllContact();
        removeSelectedContact();
    }
    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContact(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        openHomePage();
    }

    private void submitContactModification() {
        click(By.name("update"));
    }
    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}