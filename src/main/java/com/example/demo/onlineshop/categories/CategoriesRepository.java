package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface CategoriesRepository {

    Categories findOne(long id);

    List<Categories> findAll();

    Categories insert(Categories categories);

    Categories update(long id, Categories categories);

    void delete(long id);
}
