package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface ProductsRepository {

    Products findOne (long id);

    Products findByName(String name);

    List<Products> findAll();

    Products insert(Products product, long category_id);

    Products update(long id, Products product);

    void delete(long id);

}
