package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.Products;

import java.util.List;

public interface OrdersRepository  {

   Orders findOne(long id);

    Orders findByName(String name);

    List<OrdersTable> findAll();

    Orders insert(Orders order);

    Orders update(long id, Orders order);

    void delete(long id);


}
