package com.example.demo.onlineshop.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductsController {

    private final ProductsRepository repository;

    public ProductsController(ProductsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{name}")
    public Products findByName (@PathVariable String name) {
        return repository.findByName(name);
    }

//    @GetMapping("/{id}")
//    public Products findById (@PathVariable long id) {
//        return repository.findOne(id);
//    }

    @GetMapping
    public List<Products> getProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Products create(@RequestBody ProductRequest product) {
        return repository.insert(product);
    }



    @PutMapping("/{id}")
    public Products update(@PathVariable long id,
                           @RequestBody ProductRequest product) {
        return repository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }

}
