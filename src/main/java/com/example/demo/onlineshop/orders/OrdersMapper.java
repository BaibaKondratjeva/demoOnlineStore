package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.products.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Select("select id, name, imageUri from orders")
    List<Orders> findAll();

    @Select("select id, name, imageUri from orders where name like #{name}")
    Orders findByName(String name);

    @Select("select id, name, imageUri from orders where id = #{id}")
    Orders findOne(long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into orders (name, imageUri) values (#{name}, #{imageUri})")
    void insert(Orders orders);

    @Update("update orders set " +
            "name = #{name}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(Orders orders);

    @Delete("delete from orders where id = #{id}")
    boolean deleteById(long id);

    Products ordersValidation(List<Integer> categoryIds);

    void insertOrdersCategories(long productId, long categoryId);
}
