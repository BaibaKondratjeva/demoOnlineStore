package com.example.demo.onlineshop.front.cart;

import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersProductsTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Select("select products.id, products.imageUri, products.name, products.price, SUM(orders_products.quantity) as quantity, \n" +
            "(sum(orders_products.quantity) * products.price) as totalSum from orders_products \n" +
            "left join products on products.id = orders_products.product_id \n" +
            "left join orders on orders.id = orders_products.order_id where orders.user_id = #{userId} and status_id = 3 group by product_id;")
    List<CartTable> getCartProducts(String userId);

    @Select("select id, order_time, status_id, user_id from orders where user_id = #{userId} and status_id = 3")
    Long orderStatusValidation (String userId);

    @Select("select SUM(orders_products.quantity * products.price) as grandTotal from orders_products \n" +
            "left join products on products.id = orders_products.product_id \n" +
            "left join orders on orders.id = orders_products.order_id\n" +
            "where orders.user_id = #{userId} and status_id = 3")
    Integer grandTotal (String orderId);

    @Delete("delete from orders_products where order_id = #{orderId} and product_id = #{productId}")
    boolean deleteProductFromCart (Long orderId, Long productId);

    @Select("select id from orders where user_id = #{userId}")
    Long getOrderIdFromCart(String userId);
}

