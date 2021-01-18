package com.example.demo.onlineshop.front;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import com.example.demo.onlineshop.orders.OrdersRepository;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping
public class HomePageController {
    private final ProductsRepository repository;
    private final CategoriesRepository categoriesRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public HomePageController(CategoriesRepository categoriesRepository, ProductsRepository repository, OrdersRepository ordersRepository) {
        this.categoriesRepository = categoriesRepository;
        this.repository = repository;
        this.ordersRepository = ordersRepository;
    }

    @GetMapping(path = {"/"})
    public String home(@PathVariable(required = false) Long productId, Model model) {
        List<Categories> allCategories = categoriesRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        List<ProductRequest> allProducts = repository.findAll();
        model.addAttribute("allProducts", allProducts);
//        Products product = repository.findOne(productId);
//        model.addAttribute("product", product);
        return "shop/index";
    }

    @GetMapping("/about")
    public String about() {
        return "shop/about";
    }



    @GetMapping("/contactus")
    public String contactUs() {
        return "shop/contact-us";
    }

    @GetMapping("/myaccount")
    public String myAccount() {
        return "shop/my-account";
    }

    @GetMapping(path = {"/products", "/products/{categoryId}"})
    public String products(@PathVariable(required = false) Long categoryId, Model model) {
        if (categoryId == null) {
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            List<ProductRequest> allProducts = repository.findAll();
            model.addAttribute("allProducts", allProducts);
            return "shop/products";
        } else {
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            Categories category = categoriesRepository.findOne(categoryId);
            model.addAttribute("category", category);
            List<ProductRequest> allProducts = repository.findAll();
            model.addAttribute("allProducts", allProducts);
            return "shop/products";
        }
    }

    @GetMapping("/product-details")
    public String productDetails() {
        return "shop/product-details";
    }

}








