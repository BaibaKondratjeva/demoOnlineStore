package com.example.demo.onlineshop.products;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductsMapper {

    @Select("select id, name, description, price, quantity from products")
    List<Products> findAll();

    @Select("select id, name, description, price, quantity from products where id = #{id}")
    Products findById(long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products (name, description, price, quantity) values (#{name}, #{description}, #{price}, #{quantity})")
    void insert(Products product);

    @Update("update products set " +
            "name = #{name}, " +
            "description = #{description}, " +
            "price = #{price}, " +
            "quantity = #{quantoty} " +
            "where id = #{id}")
    boolean update(Products product);

    @Delete("delete from products where id = #{id}")
    boolean deleteById(long id);

}
