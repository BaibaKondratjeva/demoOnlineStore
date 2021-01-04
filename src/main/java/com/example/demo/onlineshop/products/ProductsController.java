package com.example.demo.onlineshop.products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/products")
@Controller
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

    @GetMapping (path = {"/admin/products"})
    public String getProducts(Model model) {
        List<Products> allProducts = repository.findAll();
        model.addAttribute("allProducts", allProducts);
        return "cms/products/products";
    }

    @PostMapping
    public Products create(@RequestBody ProductRequest product) {
        return repository.insert(product);
    }

    @GetMapping ("/{id}, {id}")
    public Products categoryValidation (@PathVariable long id1, long id2) {
        return repository.categoriesValidation(id1, id2);
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
