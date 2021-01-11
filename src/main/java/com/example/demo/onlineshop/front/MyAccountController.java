package com.example.demo.onlineshop.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccountController {

    @GetMapping("/myaccount")
    public String myAccount() {
        return "shop/my-account";
    }
}
