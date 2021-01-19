package com.example.demo.onlineshop.orders;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Orders {

    private long id;
    private LocalDateTime orderTime;
    private long customerId;
    private long statusId;


    public Orders() {

    }

    public Orders(long id, LocalDateTime time, long customer_id, long status) {
        this.id = id;
        this.orderTime = time;
        this.customerId = customer_id;
        this.statusId = status;

    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
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


