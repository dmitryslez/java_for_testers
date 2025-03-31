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
        click(By.cssSelector("form:nth-child(2)"));
        submitContactCreation();
        openHomePage();
    }
    public void removeContact() {
        selectContact();
        removeSelectedContact();
    }
    public void openContactPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("contact new"));
        }
    }
    private void fillContactForm(ContactData group) {
        type(By.name("firstname"), group.first_name());
        type(By.name("lastname"), group.last_name());
        type(By.name("fax"), group.fax());

    }
    private void openHomePage() {
        click(By.linkText("home page"));
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

}