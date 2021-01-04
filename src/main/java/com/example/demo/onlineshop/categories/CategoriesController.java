package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;


    public CategoriesController(CategoriesRepository repository) {
        this.categoriesRepository = repository;
    }


    @GetMapping(path = {"/admin/categories", "/admin"})
    public String categories(Model model) {
        List<Categories> allCategories = categoriesRepository.findAll();
        model.addAttribute("allCategories",allCategories);
        return "cms/categories/categories";
    }
/*    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }*/

    @GetMapping ("/{id}")
    public Categories findOne(@PathVariable long id){
        return categoriesRepository.findOne(id);
    }

    @GetMapping("/{name}")
    public Categories findByName (@PathVariable String name) {
        return categoriesRepository.findByName(name);
    }

    @PostMapping
    public Categories create(@RequestBody Categories category) {

        return categoriesRepository.insert(category);
    }

    @PutMapping("/{id}")
    public Categories update(@PathVariable long id,
                           @RequestBody Categories category) {
        return categoriesRepository.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoriesRepository.delete(id);
    }


}
