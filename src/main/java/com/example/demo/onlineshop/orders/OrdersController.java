package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @Controller
    public class OrdersController {

        private final OrdersRepository ordersRepository;


        public OrdersController(OrdersRepository repository) {
            this.ordersRepository = repository;
        }

        @GetMapping ("/admin/orders")
        public String getOrders(Model model){
            List <OrdersTable> orders = ordersRepository.findAll();
            model.addAttribute("orders",orders);
             return "cms/orders/orders";
        }

        @GetMapping ("/admin/orders/{id}")
        public Orders findOne(@PathVariable long id){
            return ordersRepository.findOne(id);
        }

        @GetMapping("/admin/orders/{name}")
        public Orders findByName (@PathVariable String name) {
            return ordersRepository.findByName(name);
        }

        @PostMapping
        public Orders create(@RequestBody Orders order) {

            return ordersRepository.insert(order);
        }

        @PutMapping("/admin/orders/{id}")
        public Orders update(@PathVariable long id,
                             @RequestBody Orders order) {
//            return OrdersRepository.update(id, order);
            return null;
        }

        @DeleteMapping("/admin/orders/{id}")
        public void delete(@PathVariable long id) {
            ordersRepository.delete(id);
        }


    }

