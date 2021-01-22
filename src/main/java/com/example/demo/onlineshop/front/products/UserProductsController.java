package com.example.demo.onlineshop.front.products;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import com.example.demo.onlineshop.cookies.CookieUtils;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersRepository;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.Products;
import com.example.demo.onlineshop.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class UserProductsController {

    private final Long ORDER_SHOPPING_STATUS_ID = 3L;
    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    UserProductsService service;

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

    @GetMapping(path = {"/products", "/categories/{categoryId}"})
    public String products(@PathVariable(required = false) Long categoryId, Model model) {
        if (categoryId == null) {
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            List<ProductRequest> allProducts = productsRepository.findAll();
            model.addAttribute("allProducts", allProducts);
            return "shop/products";
        } else {
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            Categories category = categoriesRepository.findOne(categoryId);
            model.addAttribute("category", category);
            List<ProductRequest> allProducts = productsRepository.findAll();
            model.addAttribute("allProducts", allProducts);
            return "shop/products";
        }
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable("id") Long id, Model model) {
        Products product = productsRepository.findProduct(id);
        model.addAttribute("product", product);
        return "shop/product-details";
    }

    @PostMapping("/products/{id}")
    public String addProductToCart(@PathVariable ("id") Long id,
                                   //We can use this annotation before the parameter to tell Spring to
                                   //set the value of this parameter to the value of cookie (if user has a cookie)
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   AddProductToCartForm form,
                                   HttpServletResponse response,
                                   Model model) {

        Products product = productsRepository.findProduct(id);


        if (userId == null){
            userId = UUID.randomUUID().toString();
            service.addShoppingCartCookieToResponse(response, userId);
            Orders order = new Orders();
            service.insertNewUserOrder(userId,product,form,order);

        } else if (userId != null){
            Orders order = ordersRepository.findOneWhereStatusShopping(userId);
            if (order.getStatusId().equals(ORDER_SHOPPING_STATUS_ID)) {
                ordersRepository.insertInOrdersProducts(order.getId(), product.getId(), form.getQuantity());
            } else {
                Orders newOrder = new Orders();
                service.insertNewUserOrder(userId,product,form,newOrder);
            }

        }

//        model.addAttribute("product", product);




        System.out.println("add to cart product: " + id + " and quantity " + form);
        System.out.println("Cart cookie ID: " + userId);

        model.addAttribute("product", new AddProductToCartForm());
        model.addAttribute("isSuccess", true);

        return "redirect:/products/{id}";
    }

}
