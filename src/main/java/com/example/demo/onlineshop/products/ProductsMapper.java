package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductsMapper {

    @Select("select id, name, description, price, quantity, imageUri from products")
    List<Products> findAll();

    @Select("select id, name, description, price, quantity, imageUri from products where name like #{name}")
    Products findByName(String name);

    @Select("select id, name, description, price, quantity, imageUri from products where id = #{id}")
    Products findOne(Long id);

    @Select("select id from categories id IN (#{id}, #{id})")
    Products categoriesValidation(List<Integer> categoryIds);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products (name, description, price, quantity, imageUri) values (#{name}, #{description}, #{price}, #{quantity}, #{imageUri})")
    void create(Products product);

    @Insert("insert into products_categories_set (product_id, category_id) values (#{product_id}, #{[category_id]})")
    void insertProductCategories (Long product_id, Set<Long> category_id);

//    INSERT INTO Customers (CustomerName, City, Country)
//    SELECT SupplierName, City, Country FROM Suppliers;


    @Update("update products set " +
            "name = #{name}, " +
            "description = #{description}, " +
            "price = #{price}, " +
            "quantity = #{quantity}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(Products product);

    @Delete("delete from products where id = #{id}")
    boolean deleteById(Long id);

}
