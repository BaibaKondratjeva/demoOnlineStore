package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.NotFoundException;
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
    public Categories findOne(Long id) {
        Categories category = categoriesMapper.findOne(id);
        if (category == null) {
            throw new NotFoundException("Product with id " + id + " doesn't exist");
        }
        return category;

    }

    @Override
    public Categories findByName(String name) {
        Categories category = categoriesMapper.findByName(name);
        if (category == null) {
            throw new NotFoundException("Product with name " + name + " doesn't exist");
        }
        return category;
    }

    @Override
    public List<Categories> findAll() {
        return categoriesMapper.findAll();
    }

    @Override
    public Categories create(Categories category) {
        categoriesMapper.create(category);
        return category;
    }

    @Override
    public Categories update(Long id, Categories category) {
        Categories existing = findOne(id);
        existing.setName(category.getName());
        existing.setImageUri(category.getImageUri());
        categoriesMapper.update(existing);
        return existing;
    }

    @Override
    public void delete(Long id) {
    }
}
