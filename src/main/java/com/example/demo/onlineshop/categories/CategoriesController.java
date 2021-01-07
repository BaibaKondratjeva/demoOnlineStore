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


    @GetMapping(path = {"/admin/categories"})
    public String categories(Model model) {
        List<Categories> allCategories = categoriesRepository.findAll();
        model.addAttribute("allCategories",allCategories);
        return "cms/categories/categories";
    }
/*    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }*/

    @GetMapping
    public Categories findOne(@PathVariable Long id){
        return categoriesRepository.findOne(id);
    }

/*    @GetMapping("/admin/categories/{name}")
    public String findByName (@PathVariable String name) {
        return "categoriesRepository.findByName(name)";
    }*/



    @GetMapping ("/admin/categories/new")
    public String showCreateCategoryForm(Categories category) {
        return "cms/categories/create-edit-category.html";
    }

    @PostMapping ("/admin/categories/new")
    public String createCategory (Categories category){
        categoriesRepository.create(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String showUpdateForm (@PathVariable("id") Long id, Model model) {
        Categories category = categoriesRepository.findOne(id);
        model.addAttribute("categories",category);
        return "cms/categories/update-categories";
    }

    @PostMapping("/admin/categories/update/{id}")
    public String update(@PathVariable("id") Long id, Categories category) {
        categoriesRepository.update(id, category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoriesRepository.delete(id);
        return "redirect:/admin/categories";
    }


}
