package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.orders.Orders;

public interface CheckOutRepository {

    Customer createCustomer (CheckOutForm form);

    void checkout (CheckOutForm form, String userCookieId);

    void addCustomerIdInOrders (Long orderId, Long customerId);

    void updateProductsQuantity (Long productId, int orderedQuantity);

}
