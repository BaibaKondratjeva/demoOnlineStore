package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface ProductsRepository {

    Products findOne(long id);

    List<Products> findAll();

    Products insert(Products product);

    Products update(long id, Products product);

    void delete(long id);

}
