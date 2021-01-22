package com.example.demo.onlineshop.orders;

import java.time.LocalDateTime;
import java.util.Objects;

public class Orders {

    private Long id;
    private LocalDateTime orderTime;
    private Long customerId;
    private Long statusId;
    private String userId;

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Orders() {

    }

    public Orders(long id, LocalDateTime time, long customer_id, long status) {
        this.id = id;
        this.orderTime = time;
        this.customerId = customer_id;
        this.statusId = status;


    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatusId() {
        return statusId;
    }



    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.example.demo.onlineshop.Orders orders = (com.example.demo.onlineshop.Orders) o;
        return id == orders.id &&
                customerId == orders.customer_id &&
                Objects.equals(orderTime, orders.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderTime, customerId, statusId);
    }
}


