package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.front.cart.CartMapper;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.front.checkout.CheckOutMapper;
import com.example.demo.onlineshop.front.checkout.CheckOutRepository;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersMapper;
import com.example.demo.onlineshop.orders.PersistentOrdersRepository;
import com.example.demo.onlineshop.products.PersistantProductsRepository;
import com.example.demo.onlineshop.products.Products;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CheckOutService implements CheckOutRepository {

    private final CheckOutMapper checkOutMapper;
    private final PersistentOrdersRepository ordersRepository;

    public CheckOutService(CheckOutMapper checkOutMapper, PersistentOrdersRepository ordersRepository) {
        this.checkOutMapper = checkOutMapper;
        this.ordersRepository = ordersRepository;
    }

    public void checkout (CheckOutForm form, String userCookieId) {

        if (userCookieId == null) {
            return;
        }

        Orders order = ordersRepository.getUserOrder(userCookieId);

        if (order == null) {
            return;
        }

        Customer customer = createCustomer(form);
        checkOutMapper.insertCustomer(customer);
        addCustomerIdInOrders(order.getId(), customer.getId());
        checkOutMapper.updateOrderStatus(order.getId());

        List<Products> products = checkOutMapper.findOrderedProduct(order.getId());
        for (Products product : products) {
            updateProductsQuantity(product.getId(), product.getQuantity());
        }
    }

    @Override
    public Customer createCustomer(CheckOutForm form) {
        Customer customer = new Customer();
        customer.setAddress(form.getAddress());
        customer.setE_mail(form.getEmail());
        customer.setName(form.getName());
        customer.setSurname(form.getSurname());
        customer.setPhone(form.getPhone());
        return customer;
    }

    @Override
    public void addCustomerIdInOrders (Long orderId, Long customerId) {
        checkOutMapper.createOrder(orderId, customerId);
    }

    public void updateProductsQuantity (Long productId, int orderedQuantity) {
        checkOutMapper.updateProductQuantity(productId, orderedQuantity);
    }
}
