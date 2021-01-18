package com.example.demo.onlineshop.orders;


import com.example.demo.onlineshop.categories.Categories;

import java.util.List;

public interface OrdersRepository  {

   void updateStatus (Long id, Orders order);

   Orders findOne(long id);

    Orders findByName(String name);

    List<OrdersTable> findAll();

    Orders insert(Orders order);

    Orders update(long id, Orders order);

    void delete(long id);

    List<OrdersProductsTable> getOrderedProducts (Long id);

    List <OrdersProductsTable> getCartProducts(String userId);


}
