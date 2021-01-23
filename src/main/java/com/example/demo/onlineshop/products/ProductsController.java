package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class ProductsController {
    private final ProductsRepository repository;
    private final CategoriesRepository categoriesRepository;
    public ProductsController(ProductsRepository repository, CategoriesRepository categoriesRepository) {
        this.repository = repository;
        this.categoriesRepository = categoriesRepository;
    }
    @GetMapping("/admin/products/{name}")
    public ProductRequest findByName (@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping("/admin/products/{id}")
    public ProductRequest findById (@PathVariable Long id) {
        return repository.findOne(id);
    }
    @GetMapping ("/admin/products")
    public String getProducts(Model model) {
        List<ProductRequest> allProducts = repository.findAll();
        for (ProductRequest item : allProducts) {
            item.setCategories(repository.findProductCategories(item.getId()));
        }
        model.addAttribute("allProducts", allProducts);
        return "cms/products/products";
    }
    @GetMapping ("/admin/products/new")
    public String showCreateProductsForm (Model model) {
        model.addAttribute("productRequest", new ProductRequest());
        model.addAttribute("categories", categoriesRepository.findAll());
        return "cms/products/create-edit-product.html";
    }
    @PostMapping ("/admin/products/new")
    public String createProduct (ProductRequest product) {
        repository.create(product);
        repository.insertProductCategories(product.getId(), product.getCategoryIds());
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/update/{id}")
    public String showUpdateProductForm (@PathVariable("id") Long id, Model model) {
        ProductRequest product = repository.findOne(id);
//        List<Long> productCategoryIds =
//        List<Categories> productCategories = repository.findProductCategories(product.getId());
//        product.setCategories(productCategories);
        model.addAttribute("products", product);
        model.addAttribute("categories", categoriesRepository.findAll());
        return "cms/products/update-products.html";
    }
    @PostMapping ("/admin/products/update/{id}")
    public String update(@PathVariable ("id") Long id, ProductRequest product) {
        repository.update(id, product);
//        repository.updateProductCategories(product.getId(), product.getCategoryIds());
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return "redirect:/admin/products";
    }
    @GetMapping ("/{id}, {id}")
    public ProductRequest categoryValidation (@PathVariable long id1, long id2) {
        return repository.categoriesValidation(id1, id2);
    }
}