package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.Products;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CheckOutMapper {


//    @Insert("insert into customers (name, surname, e_mail, address, phone) values (#{name}, #{surname}, " +
//            "#{e_mail}, #{address}, #{phone})")
//    void insert(CheckOutForm form);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into customers (name, surname, e_mail, address, phone) values (#{name}, #{surname}, " +
            "#{e_mail}, #{address}, #{phone})")
    void insertCustomer (Customer customer);

    @Select("select id, name, surname, e_mail, address, phone from customers where id = #{id}")
    Customer findOne(Long id);

    @Update ("update orders set customer_id = (#{customerId}) where id = #{orderId};")
    void createOrder (Long orderId, Long customerId);

    @Update("update orders \n" +
            "set status_id = 1 where id = #{id}")
    void updateOrderStatus (Long id);

    @Select("select orders.customer_id, products.id, products.name, orders_products.quantity, orders_products.order_id from orders_products\n" +
            "left join products on products.id = orders_products.product_id\n" +
            "left join orders on orders.id = orders_products.order_id\n" +
            "where orders_products.order_id = #{orderId};")
    Products findOrderedProduct (Long orderId);

//        ("select products.id, products.name, products.quantity from orders_products \n" +
//                "left join products on products.id = orders_products.product_id \n" +
//                "left join orders on orders.id = orders_products.order_id;")

    @Update("update products set quantity = (quantity - #{orderedQuantity})\n" +
            "where id = #{productId};")
    void updateProductQuantity (Long productId, int orderedQuantity);

}
