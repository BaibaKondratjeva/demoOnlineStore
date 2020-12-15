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

    @GetMapping("/{id}")
    public Products findOne(@PathVariable long id) {
        return repository.findOne(id);
    }

    @GetMapping
    public List<Products> getProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Products create(@RequestBody Products product) {
        return repository.insert(product);
    }

    @PutMapping("/{id}")
    public Products update(@PathVariable long id,
                           @RequestBody Products product) {
        return repository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }

}
