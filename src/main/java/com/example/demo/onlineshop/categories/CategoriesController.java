package com.example.demo.onlineshop.categories;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping ("/category")
@RestController
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;


    public CategoriesController(CategoriesRepository repository) {
        this.categoriesRepository = repository;
    }

    @GetMapping
    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }

    @GetMapping ("/{id}")
    public Categories findOne(@PathVariable long id){
        return categoriesRepository.findOne(id);
    }
}
