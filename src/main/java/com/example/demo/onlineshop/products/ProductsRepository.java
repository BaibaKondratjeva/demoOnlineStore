package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.products.Products;

import java.util.List;
import java.util.Set;

public interface ProductsRepository {

    Products findOne (Long id);

    Products findByName(String name);

    List<Products> findAll();

    Products create (ProductRequest product);

    Products update(Long id, ProductRequest product);

    void delete(Long id);

    Products categoriesValidation (long id1, long id2);

    void insertProductCategories (Long productId, Set<Long> categoryId);

}
