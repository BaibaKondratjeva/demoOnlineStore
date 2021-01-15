package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
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

    @Select("select id, name, imageUri from orders where name like #{name}")
    Orders findByName(String name);

    @Select("select id, name, imageUri from orders where id = #{id}")
    Orders findOne(long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into orders (name, imageUri) values (#{name}, #{imageUri})")
    void insert(Orders orders);

    @Update("update orders set status_id = 2 where id = #{id}")
    boolean updateStatus(Long id, Orders order);

    @Delete("delete from orders where id = #{id}")
    boolean deleteById(long id);

    @Select("select products.id, products.imageUri, products.name, orders_products.quantity,\n" +
            " products.price from orders_products\n" +
            "left join products on products.id = orders_products.product_id\n" +
            "left join orders on orders.id = orders_products.order_id\n" +
            "where orders_products.order_id = #{id}\n" +
            "group by product_id")
    List<OrdersProductsTable> getOrderedProducts (Long id);


    Orders ordersValidation(List<Integer> categoryIds);

    void insertOrdersCategories(long productId, long categoryId);
}
