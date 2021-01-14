package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.NotFoundException;
import com.example.demo.onlineshop.categories.Categories;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Primary
@Component
public class PersistantProductsRepository implements ProductsRepository {

    private final ProductsMapper mapper;

    public PersistantProductsRepository(ProductsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProductRequest findOne(Long id) {
        ProductRequest product = mapper.findOne(id);
        if (product == null) {
            throw new NotFoundException("Product with id " + id + " doesn't exist");
        }
        return product;
    }

    @Override
    public ProductRequest findByName(String name) {
        ProductRequest product = mapper.findByName(name);
        if (product == null) {
            throw new NotFoundException("Product with name " + name + " doesn't exist");
        }
        return product;
    }

    @Override
    public List<ProductRequest> findAll() {
        return mapper.findAll();
    }

    public List<Categories> findProductCategories(Long productId) {
        return mapper.findProductCategories(productId);
    }

    @Override
    public ProductRequest create(ProductRequest product) {
        mapper.create(product);
        product.setCategories(mapper.findProductCategories(product.getId()));
        return product;
    }

    @Override
    public ProductRequest update(Long id, ProductRequest product) {
        ProductRequest existing = findOne(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setImageUri(product.getImageUri());
        existing.setCategoryIds(product.getCategoryIds());
        mapper.update(existing);
        return existing;
    }

    public void updateProductCategories (Long productId, Set<Long> categoryId) {
//        ProductRequest existing = findOne(productId);
//        existing.setCategoryIds(categoryId);
        mapper.updateProductCategory(productId, categoryId);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }


    public void insertProductCategories (Long productId, Set<Long> categoryId) {
        mapper.insertProductCategories(productId, categoryId);
    }


    public ProductRequest categoriesValidation (long id1, long id2){
        List<Integer> categoryIds = new ArrayList<>();
        if (categoryIds == null) {
            throw new NotFoundException("Such id not found");
        }
        return mapper.categoriesValidation(categoryIds);
    }

}
