package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.NotFoundException;
import com.example.demo.onlineshop.categories.Categories;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Primary
@Component
public class PersistantProductsRepository implements ProductsRepository {

    private final ProductsMapper mapper;

    public PersistantProductsRepository(ProductsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Products findOne(long id) {
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
    public Products insert(ProductRequest request) {
        Products product = new Products(request);
        mapper.insert(product);
        return product;
    }

    @Override
    public Products update(long id, ProductRequest product) {
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
    public void delete(long id) {

    }
}
