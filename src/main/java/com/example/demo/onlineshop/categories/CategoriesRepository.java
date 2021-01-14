package com.example.demo.onlineshop.categories;


import java.util.List;

public interface CategoriesRepository {

    Categories findOne(Long id);

    Categories findByName(String name);

    List<Categories> findAll();

    Categories create(Categories category);

    Categories update(Long id, Categories category);

    void delete(Long id);
}
