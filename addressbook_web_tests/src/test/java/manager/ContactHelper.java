package manager;

import model.ContactData;
import org.openqa.selenium.By;

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
    public void removeContact() {
        selectContact();
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


    private void selectContact() {
        click(By.name("selected[]"));

    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }
    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();

    }

    public void removeAllContact() {
        openHomePage();
        selectAllContact();
        removeSelectedContact();
    }

    private void selectAllContact() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }
}