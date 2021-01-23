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
    private final PersistantProductsRepository productsRepository;
    private final CartMapper cartMapper;

    public CheckOutService(CheckOutMapper checkOutMapper, PersistentOrdersRepository ordersRepository, PersistantProductsRepository productsRepository, CartMapper cartMapper) {
        this.checkOutMapper = checkOutMapper;
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
        this.cartMapper = cartMapper;
    }

    public void checkout (CheckOutForm form, String userCookieId) {

        if (userCookieId == null) {
            return;
        }

        Orders order = ordersRepository.getUserOrder(userCookieId);

        if (order == null) {
            return;
        }

        //returns true if we have enough products in stock
        //compare ordered product quantity with product stock quantity
        //for each product in this particular order
//        if (verifyProductCount(order.getId())) {
//            // we can't continue, because one of the products are missing
//            return;
//        }

        Customer customer = createCustomer(form);
        checkOutMapper.insertCustomer(customer);
        addCustomerIdInOrders(order.getId(), customer.getId());
//        checkOutMapper.updateOrderStatus(order.getId());

        Products product = checkOutMapper.findOrderedProduct(order.getId());
        updateProductsQuantity(product.getId(), product.getQuantity());
        checkOutMapper.updateOrderStatus(order.getId());


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
    public void addCustomerIdInOrders (Long orderId, Long customerId) {
        checkOutMapper.createOrder(orderId, customerId);
    }

//    public void completeOrder (Long orderId) {
//        checkOutMapper.updateOrderStatus(orderId);
//
//    }

    public void updateProductsQuantity (Long productId, int orderedQuantity) {
        checkOutMapper.updateProductQuantity(productId, orderedQuantity);
    }



    //    public boolean verifyProductCount (Long id) {
//
//        Products product =
//
//    }

}
