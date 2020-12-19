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
                           @RequestBody Products product) {
        return repository.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.delete(id);
    }

}
