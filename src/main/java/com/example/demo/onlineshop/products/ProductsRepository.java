package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface ProductsRepository {

    Products findOne(long id);

    List<Products> findAll();

    Products insert(Products products);

    Products update(long id, Products products);

    void delete(long id);

}
