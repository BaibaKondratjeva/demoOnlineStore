package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.NotFoundException;
import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.products.Products;

import java.util.ArrayList;
import java.util.List;

public class PersistentOrdersRepository implements OrdersRepository {
    private final OrdersMapper mapper;

    public PersistentOrdersRepository(OrdersMapper mapper) {
        this.mapper = mapper;
    }

    public PersistentOrdersRepository(OrdersMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Orders findOne(long id) {
        Orders orders = mapper.findOne(id);
        if (orders == null) {
            throw new NotFoundException("Orders with id " + id + " doesn't exist");
        }
        return orders;
    }

    @Override
    public Orders findByName(String name) {
        Orders orders = mapper.findByName(name);
        if (orders == null) {
            throw new NotFoundException("Orders with name " + name + " doesn't exist");
        }
        return orders;
    }

    @Override
    public List<Orders> findAll() {
        return mapper.findAll();
    }

    @Override
    public Orders insert(Orders order) {
        return null;
    }

    @Override
    public Orders update(long id, Orders order) {
        return null;
    }


    @Override
        public Orders insert(OrdersRequest request) {
        Orders orders = new Orders(request);
        mapper.insert(orders);
        return orders;
    }

    @Override
    public Orders update(long id, OrdersRequest product) {
        Orders existing = findOne(id);
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
        mapper.deleteById(id);
    }

    public Products categoriesValidation (long id1, long id2){
        List<Integer> categoryIds = new ArrayList<>();
        if (categoryIds == null) {
            throw new NotFoundException("Such id not found");
        }
        return mapper.ordersValidation(categoryIds);
    }

    public void insertOrdersCategories (long productId, long categoryId) {
        mapper.insertOrdersCategories(productId, categoryId);
    }

}
