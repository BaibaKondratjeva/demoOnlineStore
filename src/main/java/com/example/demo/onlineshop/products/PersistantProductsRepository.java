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
    public Products findOne(Long id) {
        Products product = mapper.findOne(id);
        if (product == null) {
            throw new NotFoundException("Product with id " + id + " doesn't exist");
        }
        return product;
    }

    @Override
    public Products findByName(String name) {
        Products product = mapper.findByName(name);
        if (product == null) {
            throw new NotFoundException("Product with name " + name + " doesn't exist");
        }
        return product;
    }

    @Override
    public List<Products> findAll() {
        return mapper.findAll();
    }

    @Override
    public Products create(ProductRequest request) {
        Products product = new Products(request);
        mapper.create(product);
        return product;
    }

    @Override
    public Products update(Long id, ProductRequest product) {
        Products existing = findOne(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setImageUri(product.getImageUri());
        mapper.update(existing);
        return existing;
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

    public Products categoriesValidation (long id1, long id2){
        List<Integer> categoryIds = new ArrayList<>();
        if (categoryIds == null) {
            throw new NotFoundException("Such id not found");
        }
       return mapper.categoriesValidation(categoryIds);
    }

    public void insertProductCategories (Long productId, Set<Long> categoryId) {
        mapper.insertProductCategories(productId, categoryId);
    }

}
