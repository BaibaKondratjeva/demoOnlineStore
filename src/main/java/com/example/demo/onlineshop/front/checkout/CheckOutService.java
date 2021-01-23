package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
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

@Service
public class CheckOutService implements CheckOutRepository {

    private final CheckOutMapper checkOutMapper;
    private final PersistentOrdersRepository ordersRepository;
    private final PersistantProductsRepository productsRepository;

    public CheckOutService(CheckOutMapper checkOutMapper, PersistentOrdersRepository ordersRepository, PersistantProductsRepository productsRepository) {
        this.checkOutMapper = checkOutMapper;
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
    }

    public void checkout (CheckOutForm form, Long userCookieId) {

        checkOutMapper.insert(form);

        if (userCookieId == null) {
            //user hasn't added any product in his cart
            return;
        }


//        Orders order = ordersRepository.findOrderByUserIdAndStatusName(userCookieId, userCookieId);

//        Orders order = orderService.findOrderByUserIdAndStatusName(userCookieId, IN_PROGRESS.name());
//        if (order == null) {
//            //user had cookie, but there is no such order in database
//            return;
//        }
        //returns true if we have enough products in stock
        //compare ordered product quantity with product stock quantity
        //for each product in this particular order
//        if (verifyProductCount(order.getId())) {
//            // we can't continue, because one of the products are missing
//            return;
//        }
        Customer customer = createCustomer(form);
        checkOutMapper.insert(form);
//        customerRepository.insert(customer);
        //updates order entry in database (sets customerId)
//        orderService.updateOrderCustomerId(order.getId(), customer.getId());
        //updates order status to PENDING_APPROVAL
        //and updates product count in stock
//        orderService.completeOrder(order.getId());

    }

    @Override
    public Customer createCustomer(CheckOutForm form) {
        Customer customer = new Customer();
        customer.setAddress(form.getAddress());
        customer.setE_mail(form.getE_mail());
        customer.setName(form.getName());
        customer.setSurname(form.getSurname());
        customer.setPhone(form.getPhone());
        return customer;
    }

    @Override
    public Orders createOrder(Long customerId, Orders order) {
        Customer customer = checkOutMapper.findOne(customerId);
        checkOutMapper.createOrder(customer.getId(), order);
        return order;
    }

//    public boolean verifyProductCount (Long id) {
//
//        Products product =
//
//    }

}
