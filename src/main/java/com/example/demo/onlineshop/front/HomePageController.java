package com.example.demo.onlineshop.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String home() {
        return "shop/index";
    }

    @GetMapping("/about")
    public String about() {
        return "shop/about";
    }

    @GetMapping("/cart")
    public String cart() {
        return "shop/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "shop/checkout";
    }

    @GetMapping("/contactus")
    public String contactUs() {
        return "shop/contact-us";
    }

    @GetMapping("/myaccount")
    public String myAccount() {
        return "shop/my-account";
    }

    @GetMapping("/products")
    public String products() {
        return "shop/products";
    }

    @GetMapping("/productdetails")
    public String productDetails() {
        return "shop/product-details";
    }

}








