package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.Orders;

public interface CheckOutRepository {

    CheckOutForm createCustomer (CheckOutForm form);

    Orders createOrder (Long customerId, Orders order);

}
