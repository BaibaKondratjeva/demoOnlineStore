package com.example.demo.onlineshop;

import java.util.Objects;

public class Customer {

    private long id;
    private String name;
    private String surname;
    private String eMail;
    private String address;
    private String phone;

    public Customer() {

    }

    public Customer(long id, String name, String surname, String e_mail, String address, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = e_mail;
        this.address = address;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(eMail, customer.eMail) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(phone, customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, eMail, address, phone);
    }
}
