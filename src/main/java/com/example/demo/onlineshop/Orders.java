package com.example.demo.onlineshop;

import java.time.LocalDateTime;
import java.util.Objects;

public class Orders {

    public long id;
    public LocalDateTime time;
    public long customer_id;

    public Orders(){

    }

    public Orders(long id, LocalDateTime time, long customer_id) {
        this.id = id;
        this.time = time;
        this.customer_id = customer_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                customer_id == orders.customer_id &&
                Objects.equals(time, orders.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, customer_id);
    }
}
