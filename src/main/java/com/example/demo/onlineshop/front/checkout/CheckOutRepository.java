package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.orders.Orders;

public interface CheckOutRepository {

    Customer createCustomer (CheckOutForm form);

    Orders createOrder (Long customerId, Orders order);

//    void checkout(CheckOutForm form, String userId);

    void checkout (CheckOutForm form, Long userCookieId);


}
