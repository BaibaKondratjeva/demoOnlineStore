package com.example.demo.onlineshop.orders;


import java.util.List;

public interface OrdersRepository  {

   Orders findOne(long id);

    Orders findByName(String name);

    List<OrdersTable> findAll();

    Orders insert(Orders order);

    Orders update(long id, Orders order);

    void delete(long id);


}
