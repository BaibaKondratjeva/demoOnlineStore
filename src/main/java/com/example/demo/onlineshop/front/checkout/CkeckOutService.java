package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.Orders;
import com.example.demo.onlineshop.front.checkout.CheckOutMapper;
import com.example.demo.onlineshop.front.checkout.CheckOutRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class CkeckOutService implements CheckOutRepository {

    private final CheckOutMapper checkOutMapper;

    public CkeckOutService(CheckOutMapper checkOutMapper) {
        this.checkOutMapper = checkOutMapper;
    }

    @Override
    public CheckOutForm createCustomer(CheckOutForm form) {
        checkOutMapper.createCustomer(form);
        return form;
    }

    @Override
    public Orders createOrder(Long customerId, Orders order) {
        Customer customer = checkOutMapper.findOne(customerId);
        checkOutMapper.createOrder(customer.getId(), order);
        return order;
    }




}
