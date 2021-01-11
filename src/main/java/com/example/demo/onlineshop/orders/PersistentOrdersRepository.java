package com.example.demo.onlineshop.orders;

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
    public Orders findOne(long id) {
//        Orders orders = mapper.findOne(id);
//        if (orders == null) {
//            throw new NotFoundException("Orders with id " + id + " doesn't exist");
//        }
//        return orders;
        return null;
    }

    @Override
    public Orders findByName(String name) {
//        Orders orders = mapper.findByName(name);
//        if (orders == null) {
//            throw new NotFoundException("Orders with name " + name + " doesn't exist");
//        }
//        return orders;
        return null;
    }

    @Override
    public List<OrdersTable> findAll() {
        return mapper.findAll();
    }

    @Override
        public Orders insert(Orders order) {
//        Orders orders = new Orders(request);
//        mapper.insert(orders);
//        return orders;
        return null;
    }

    @Override
    public Orders update(long id, Orders order) {
//        Orders existing = findOne(id);
//        existing.setName(product.getName());
//        existing.setDescription(product.getDescription());
//        existing.setPrice(product.getPrice());
//        existing.setQuantity(product.getQuantity());
//        existing.setImageUri(product.getImageUri());
//        mapper.update(existing);
//        return existing;
        return null;
    }

    @Override
    public void delete(long id) {

        mapper.deleteById(id);
    }

}
