package com.example.demo.onlineshop.front.checkout;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.demo.onlineshop.regex.RegexConstants.EMAIL_PATTERN;


public class CheckOutForm {

    @Size(min = 2, max = 20)
    @NotBlank
    private String name;

    @Size(min = 2, max = 20)
    @NotBlank
    private String surname;

    @Size(min = 5, max = 30)
    @NotBlank
    @Pattern(regexp = EMAIL_PATTERN, message = "Incorrect format")
    private String email;

    @NotBlank
    @Size(min = 4, max = 100)
    private String address;

    @Size(min = 5, max = 12)
    @NotBlank
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e_mail) {
        this.email = e_mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CheckoutForm{" +
                "firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                ", Email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
