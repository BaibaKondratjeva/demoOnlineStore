package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.NotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary
@Component
public class PersistentOrdersRepository implements OrdersRepository {
    private final OrdersMapper mapper;

    public PersistentOrdersRepository(OrdersMapper mapper) {
        this.mapper = mapper;
    }

    @Override

    public void updateStatus (long id, Orders order){
         mapper.updateStatus(id,order);
    }

    @Override
    public List<OrdersProductsTable> getOrderedProducts (Long id){
        return mapper.getOrderedProducts(id);
    }


    @Override
    public Orders findOne(long id) {
//       Orders orders = mapper.findOne(id);
//        if (orders == null) {
//            throw new NotFoundException("Orders with id " + id + " doesn't exist");
//        }
//        return orders;
        return mapper.findOne(id);
    }

    @Override
    public Orders findByUserId(String userId) {
        Orders orders = mapper.findByUserId(userId);
        if (orders == null) {
           throw new NotFoundException("Orders with name " + userId + " doesn't exist");
        }
       return orders;
    }

    @Override
    public Orders findOneWhereStatusShopping(String userId) {
        return mapper.findOneWhereStatusShopping(userId);
    }

    @Override
    public List<OrdersTable> findAll() {
        return mapper.findAll();

    }

    @Override
        public Orders insert(Orders order) {
        Orders orders = new Orders();
        //mapper.insert(orders);
        return orders;

    }

    @Override
    public void insertNewOrder(Long statusId, String userId) {
        mapper.insertNewOrder(statusId,userId);
    }

    @Override
    public void insertInOrdersProducts(Long orderId, Long productId, Integer quantity) {
        mapper.insertInOrdersProducts(orderId,productId,quantity);
    }


    @Override
    public void delete(Long id) {

        mapper.deleteById(id);
    }


}
