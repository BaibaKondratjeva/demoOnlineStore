package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;

import java.util.List;
import java.util.Set;

public interface ProductsRepository {

    ProductRequest findOne (Long id);

    ProductRequest findByName(String name);

    List<ProductRequest> findAll();

    List<Categories> findProductCategories(Long productId);

    ProductRequest create (ProductRequest product);

    ProductRequest update(Long id, ProductRequest product);

    void delete(Long id);

    ProductRequest categoriesValidation (long id1, long id2);

    void insertProductCategories (Long productId, Set<Long> categoryId);

    void updateProductCategories (Long productId, Set<Long> categoryId);

}
