package com.example.demo.onlineshop.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopDetailsController {

    @GetMapping("/shopdetails")
    public String shopDetails() {
        return "shop/shop-detail";
    }
}
