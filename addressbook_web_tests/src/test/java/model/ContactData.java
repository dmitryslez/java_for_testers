package model;

public record ContactData(String first_name, String last_name, String fax) {

    public ContactData() {
        this("", "", "");
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(first_name, this.last_name, this.fax);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.first_name, last_name, this.fax);
    }

    public ContactData withFax(String fax) {
        return new ContactData(this.first_name, this.last_name, fax);
    }
}