package com.example.demo.onlineshop.products;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductsMapper {

    @Select("select id, name, description, price, quantity from products")
    List<Products> findAll();

}
