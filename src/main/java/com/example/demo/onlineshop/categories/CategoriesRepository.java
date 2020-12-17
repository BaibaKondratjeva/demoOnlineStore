package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface CategoriesRepository {

    Categories findOne(long id);

    Categories findByName(String name)

    List<Categories> findAll();

    Categories insert(Categories category);

    Categories update(long id, Categories category);

    void delete(long id);
}
