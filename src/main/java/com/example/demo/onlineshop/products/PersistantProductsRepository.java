package com.example.demo.onlineshop.products;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class PersistantProductsRepository implements ProductsRepository {

    private final ProductsMapper mapper;

    public PersistantProductsRepository(Products mapper) {
        this.mapper = mapper;
    }

    @Override
    public Products findOne(long id) {
        return null;
    }

    @Override
    public List<Products> findAll() {
        return mapper.findAll();
    }

    @Override
    public Products insert(Products products) {
        return null;
    }

    @Override
    public Products update(long id, Products products) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
