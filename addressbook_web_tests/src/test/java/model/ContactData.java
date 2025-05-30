package model;

public record ContactData(String id, String first_name, String last_name, String photo, String fax) {

    public ContactData() {
        this("", "","","","");
    }
    public ContactData withId(String id) {
        return new ContactData(id, first_name,this.last_name,this.photo,this.fax);
    }
    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name,this.last_name,this.photo,this.fax);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.photo,this.fax);
    }

    public ContactData withFax(String fax) {
        return new ContactData(this.id, this.first_name,this.last_name,this.photo,fax);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name,this.last_name,photo,this.fax);
    }
}