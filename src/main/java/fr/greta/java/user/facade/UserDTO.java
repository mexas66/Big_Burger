package fr.greta.java.user.facade;

import fr.greta.java.adress.facade.AddressDTO;

public class UserDTO {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private AddressDTO addressDTO;

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



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDTO getAdressDTO() {
        return addressDTO;
    }

    public void setAdressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
