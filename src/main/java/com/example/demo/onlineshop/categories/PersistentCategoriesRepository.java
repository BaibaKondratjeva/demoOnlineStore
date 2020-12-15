package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersistentCategoriesRepository implements CategoriesRepository{
    @Override
    public Products findOne(long id) {
        return null;
    }

    @Override
    public List<Products> findAll() {
        return null;
    }

    @Override
    public Products insert(Products product) {
        return null;
    }

    @Override
    public Products update(long id, Products product) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
