package com.example.demo.onlineshop.products;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductsMapper {

    @Select("select id, name, description, price, quantity, imageUri from products")
    List<Products> findAll();

    @Select("select id, name, description, price, quantity, imageUri from products where name like #{name}")
    Products findByName(String name);

    @Select("select id, name, description, price, quantity, imageUri from products where id = #{id}")
    Products findOne(long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products (name, description, price, quantity, imageUri, category_id) values (#{name}, #{description}, #{price}, #{quantity}, #{imageUri}, #{category_id})")
    void insert(Products product, long category_id);

    @Update("update products set " +
            "name = #{name}, " +
            "description = #{description}, " +
            "price = #{price}, " +
            "quantity = #{quantity}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(Products product);

    @Delete("delete from products where id = #{id}")
    boolean deleteById(long id);

}
