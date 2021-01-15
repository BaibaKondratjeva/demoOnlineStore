package com.example.demo.onlineshop.orders;

import java.time.LocalDateTime;
import java.util.List;

public class OrdersTable {

    private long id;
    private LocalDateTime orderTime;
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String status;
    private Integer totalSum;
    private List<OrdersProductsTable> orderedProducts;

    public List<OrdersProductsTable> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrdersProductsTable> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersTable{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", totalSum=" + totalSum +
                ", orderedProducts=" + orderedProducts +
                '}';
    }
}
