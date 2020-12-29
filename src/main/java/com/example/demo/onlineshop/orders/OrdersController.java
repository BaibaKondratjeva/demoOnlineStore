package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RequestMapping("/orders")
    @RestController
    public class OrdersController {

        private final OrdersRepository ordersRepository;


        public OrdersController(OrdersRepository repository) {
            this.ordersRepository = repository;
        }

        @GetMapping
        public List<Categories> getOrders(){
            return ordersRepository.findAll();
        }

        @GetMapping ("/{id}")
        public Categories findOne(@PathVariable long id){
            return ordersRepository.findOne(id);
        }

        @GetMapping("/{name}")
        public Categories findByName (@PathVariable String name) {
            return ordersRepository.findByName(name);
        }

        @PostMapping
        public Categories create(@RequestBody Orders orders) {

            return ordersRepository.insert(orders);
        }

        @PutMapping("/{id}")
        public Orders update(@PathVariable long id,
                             @RequestBody Orders orders) {
            return OrdersRepository.update(id, orders);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable long id) {
            ordersRepository.delete(id);
        }


    }

