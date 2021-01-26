package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.products.ProductRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {


    @Select("select orders.id as Id, orders.order_time as orderTime,customers.name, customers.surname,\n" +
            " customers.address, customers.phone, order_status.status,\n" +
            "       SUM(orders_products.quantity * products.price) as totalSum from orders\n" +
            "left join orders_products on orders_products.order_id = orders.id\n" +
            "left join products on products.id = orders_products.product_id\n" +
            "left join customers on orders.customer_id = customers.id\n" +
            "left join order_status on orders.status_id = order_status.id\n" +
            "group by orders.id;")
    List<OrdersTable> findAll();



    @Select("select id, order_time, status_id, user_id from orders where user_id = #{userId}")
    Orders findByUserId(String userId);

    @Select("select id, order_time, status_id, user_id from orders where user_id = #{userId} and status_id = 3")
    Orders findOneWhereStatusShopping (String userId);

    @Select("select id, order_time, status_id, customer_id from orders where id = #{id}")
    Orders findOne(Long id);


    @Insert("insert into orders (status_id, user_id) values ( #{statusId}, #{userId})")
    void insertNewOrder(Long statusId,String userId);

    @Insert("insert into orders_products (order_id, product_id, quantity) values (#{orderId}, #{productId},#{quantity})")
    void insertInOrdersProducts (Long orderId,Long productId,Integer quantity);

    @Update("update orders set status_id = 2 where id = #{id}")
    boolean updateStatus(Long id, Orders order);

    @Delete("delete from orders where id = #{id}")
    boolean deleteById(Long id);

    @Select("select products.id, products.imageUri, products.name, orders_products.quantity,\n" +
            " products.price from orders_products\n" +
            "left join products on products.id = orders_products.product_id\n" +
            "left join orders on orders.id = orders_products.order_id\n" +
            "where orders_products.order_id = #{id}")
    List<OrdersProductsTable> getOrderedProducts (Long id);

    @Select("select id, order_time, customer_id, status_id, user_id from orders where status_id = 3 and user_id = #{userId}")
    Orders getUserOrder(@Param("userId") String userId);



}
