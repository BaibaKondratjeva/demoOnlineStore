package com.example.demo.onlineshop.front.products;

import com.example.demo.cookies.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class UserProductsController {

/*    @GetMapping({"/products", "/products/{categoryName}"})
    public String products(@PathVariable(required = false) String categoryName,
                           @RequestParam(required = false) String sortBy) {
        System.out.println("Category: " + categoryName);
        return "shop/products";
    }

    @GetMapping("/product/{productId}")
    public String productDetails(@PathVariable Long productId,
                                 Model model) {
        //TODO load product details from database by product ID and
        //put them in model
        model.addAttribute("productForm", new AddProductToCartForm());
        return "shop/product-details";
    }*/

    @PostMapping("/product/{productId}")
    public String addProductToCart(@PathVariable Long productId,
                                   //We can use this annotation before the parameter to tell Spring to
                                   //set the value of this parameter to the value of cookie (if user has a cookie)
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   AddProductToCartForm form,
                                   HttpServletResponse response,
                                   Model model) {
        System.out.println("add to cart product: " + productId + " and quantity " + form);
        System.out.println("Cart cookie ID: " + userId);

        model.addAttribute("productForm", new AddProductToCartForm());
        model.addAttribute("isSuccess", true);

        String userIdentifier = UUID.randomUUID().toString(); // example how we can create unique identifier

        //Example of how we can generate unique ID and set cookie for user
        addShoppingCartCookieToResponse(response, userIdentifier);
        return "shop/product-details";
    }

    private void addShoppingCartCookieToResponse(HttpServletResponse response, String cookieValue) {
        Cookie cookie = CookieUtils.createCookie(USER_ID_COOKIE_NAME, cookieValue);
        response.addCookie(cookie);
    }
}
