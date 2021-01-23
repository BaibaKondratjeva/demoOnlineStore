package com.example.demo.onlineshop.orders;


import java.util.List;

public interface OrdersRepository  {

   void updateStatus (long id,Orders order);

   Orders findOne(long id);

   Orders findByUserId(String userId);

    Orders findOneWhereStatusShopping (String userId);

    List<OrdersTable> findAll();

    Orders insert(Orders order);

    void insertNewOrder (Long statusId, String userId);

    void insertInOrdersProducts (Long orderId, Long productId, Integer quantity);

    void delete(Long id);

    List<OrdersProductsTable> getOrderedProducts (Long id);

    Orders getUserOrder (String userId);

//    Orders findOrderByUserIdAndStatusName (Long userCookieId, Long statusId);


}
