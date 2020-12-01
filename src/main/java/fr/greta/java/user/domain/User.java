package fr.greta.java.user.domain;

import fr.greta.java.adress.domain.Address;

public class User {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String phone;
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAdress() {
        return address;
    }

    public void setAdress(Address address) {
        this.address = address;
    }
}
