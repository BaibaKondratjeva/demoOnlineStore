package com.example.demo.onlineshop.front.products;

import com.example.demo.onlineshop.cookies.CookieUtils;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersRepository;
import com.example.demo.onlineshop.products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;
@Component
public class UserProductsService {
    @Autowired
    OrdersRepository ordersRepository;
    private final Long ORDER_SHOPPING_STATUS_ID = 3L;
    public String userId;

    void insertNewUserOrder (String userId, Products product,AddProductToCartForm form, Orders order){
        ordersRepository.insertNewOrder(ORDER_SHOPPING_STATUS_ID,userId);
        order = ordersRepository.findByUserId(userId);
        ordersRepository.insertInOrdersProducts(order.getId(),product.getId(),form.getQuantity());

    }

    void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }
}
