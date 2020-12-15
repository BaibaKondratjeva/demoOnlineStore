package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersistentCategoriesRepository implements CategoriesRepository{

    private final CategoriesMapper categoriesMapper;

    public PersistentCategoriesRepository(CategoriesMapper categoriesMapper) {
        this.categoriesMapper = categoriesMapper;
    }


    @Override
    public Categories findOne(long id) {
        return null;
    }

    @Override
    public List<Categories> findAll() {
        return null;
    }

    @Override
    public Categories insert(Categories categories) {
        return null;
    }

    @Override
    public Categories update(long id, Categories categories) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
