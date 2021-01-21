package com.example.demo.onlineshop.orders;


import com.example.demo.onlineshop.categories.CategoriesRepository;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class OrdersController {
    @Autowired
    private  OrdersRepository ordersRepository;
    private final Long ORDER_PENDING_STATUS_ID = 1L;

    public OrdersController(/*OrdersRepository repository*/) {
        /*this.ordersRepository = repository;*/
    }
    @GetMapping ("/admin/orders")
    public String getOrders(Model model){
        List <OrdersTable> orders = ordersRepository.findAll();
        for (OrdersTable order:orders) {
            order.setOrderedProducts(ordersRepository.getOrderedProducts(order.getId()));

        }
        model.addAttribute("orders",orders);
        return "cms/orders/orders";
    }
    @GetMapping ("/admin/orders/update/{id}")
    public String updateStatus(@PathVariable("id") Long id ){
        Orders order =ordersRepository.findOne(id);
            if (ORDER_PENDING_STATUS_ID.equals(order.getStatusId())) {
                ordersRepository.updateStatus(id, order);

            }
        System.out.println("orderr status id is:"+ order.getStatusId());

         return "redirect:/admin/orders";
    }

    @GetMapping("/admin/orders/{id}")
    public Orders findOne (@PathVariable ("id") Long id) {
        System.out.println("Order :" + ordersRepository.findOne(id));
        Orders order =ordersRepository.findOne(id);
        System.out.println(order.getStatusId());
        return ordersRepository.findOne(id);
    }


/*    @GetMapping("/admin/orders/name/{name}")
    public Orders findByName (@PathVariable String name) {
        System.out.println(ordersRepository.findByName(name));
        return ordersRepository.findByName(name);
    }*/

    @PostMapping

    public Orders create(@RequestBody Orders order) {
        return ordersRepository.insert(order);
    }
/*    @PutMapping("/admin/orders/{id}")
    public Orders update(@PathVariable long id,
                         @RequestBody Orders order) {
//            return OrdersRepository.update(id, order);
        return null;
    }*/
    @GetMapping("/admin/orders/delete/{id}")
    public String delete(@PathVariable ("id") long id) {
        ordersRepository.delete(id);
        return "redirect:/admin/orders/";
    }
}

