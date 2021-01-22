package com.example.demo.onlineshop.front.cart;

import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersProductsTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select products.imageUri, products.name, products.price, orders_products.quantity,\n" +
            "(orders_products.quantity * products.price) as totalSum, \n" +
            "SUM(orders_products.quantity * products.price) as grandTotal from orders_products\n" +
            "left join products on products.id = orders_products.product_id\n" +
            "left join orders on orders.id = orders_products.order_id \n" +
            "where orders.user_id = #{userId}  group by product_id")
    List<CartTable> getCartProducts(String userId);

    @Select("select status_id from orders where id = #{userId}")
    Long orderStatusValidation (String userId);

    @Select("select SUM(orders_products.quantity * products.price) as grandTotal from orders_products \n" +
            "left join products on products.id = orders_products.product_id \n" +
            "left join orders on orders.id = orders_products.order_id\n" +
            "where orders.user_id = #{userId}")
    Integer grandTotal (String orderId);
}
