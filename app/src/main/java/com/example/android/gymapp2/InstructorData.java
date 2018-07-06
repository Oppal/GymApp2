package com.example.android.gymapp2;

public class InstructorData {

private int id;
private String firstname,lastname,alias, base_gym, phone_number, image;

public InstructorData(int id, String firstname, String lastname, String alias, String base_gym, String phone_number, String image){
this.id = id;
this.firstname = firstname;
this.lastname = lastname;
this.alias = alias;
this.base_gym = base_gym;
this.phone_number = phone_number;
this.image = image;


}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBase_gym() {
        return base_gym;
    }

    public void setBase_gym(String base_gym) {
        this.base_gym = base_gym;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
