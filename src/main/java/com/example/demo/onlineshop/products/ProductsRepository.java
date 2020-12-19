package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface ProductsRepository {

    Products findOne (long id);

    Products findByName(String name);

    List<Products> findAll();

    Products insert(ProductRequest product);

    Products update(long id, ProductRequest product);

    void delete(long id);

    Products categoriesValidation (long id1, long id2);

    void insertProductCategories (long productId, long categoryId);

}
