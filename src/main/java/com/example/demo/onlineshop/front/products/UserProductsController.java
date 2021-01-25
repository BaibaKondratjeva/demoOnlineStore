package com.example.demo.onlineshop.front.products;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import com.example.demo.onlineshop.front.cart.CartMapper;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersRepository;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.Products;
import com.example.demo.onlineshop.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class UserProductsController {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    UserProductsService service;


    @GetMapping(path = {"/products", "/categories/{categoryId}"})
    public String products(@PathVariable(required = false) Long categoryId,
                           @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                           Model model) {
        if (categoryId == null) {
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            List<ProductRequest> allProducts = productsRepository.findAll();
            model.addAttribute("allProducts", allProducts);
            List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
            model.addAttribute("cartProducts",cartProducts);
            return "shop/products";
        } else {
            List<ProductRequest> productsByCategories = productsRepository.productsByCategoryId(categoryId);
            model.addAttribute("allProducts", productsByCategories);
            List<Categories> allCategories = categoriesRepository.findAll();
            model.addAttribute("allCategories", allCategories);
            List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
            model.addAttribute("cartProducts",cartProducts);

//            List<Categories> allCategories = categoriesRepository.findAll();
//            model.addAttribute("allCategories", allCategories);
//            Categories category = categoriesRepository.findOne(categoryId);
//            model.addAttribute("category", category);
//            List<ProductRequest> allProducts = productsRepository.findAll();
//            model.addAttribute("allProducts", allProducts);
            return "shop/products";
        }
    }

    @PostMapping(path = {"/products", "/categories/{categoryId}"})
    public String addProductToCartCategoryViewFrom(@PathVariable(value = "productId", required = false) Long productId,
                                                   @PathVariable (value = "categoryId",required = false) Long categoryId,
                                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                                   Model model,
                                                   @Valid AddProductToCartForm form,
                                                   BindingResult bindingResult,
                                                   HttpServletResponse response) {
        if (productId == null) {
            productId = form.getProductId();
        }
        Products product = productsRepository.findProduct(productId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "shop/products";
        }
        if (userId == null){
            userId = UUID.randomUUID().toString();
            service.addShoppingCartCookieToResponse(response, userId);
            Orders order = new Orders();
            service.insertNewUserOrder(userId,product,form,order);
        } else if (userId != null){
            Orders order = ordersRepository.findOneWhereStatusShopping(userId);
            if (ordersRepository.findOneWhereStatusShopping(userId) != null){
                ordersRepository.insertInOrdersProducts(order.getId(), product.getId(), form.getQuantity());
            } else {
                Orders newOrder = new Orders();
                service.insertNewUserOrder(userId,product,form,newOrder);
            }
        } return "redirect:/categories/{categoryId}";

    }

    @GetMapping("/products/{productId}")
    public String productDetails(@PathVariable("productId") Long id, Model model) {
        Products product = productsRepository.findProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("addProductToCartForm", new AddProductToCartForm());
        return "shop/product-details";
    }

    @PostMapping("/products/{productId}")
    public String addProductToCart(@PathVariable ("productId") Long productId,
                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                   Model model,
                                   @Valid AddProductToCartForm form,
                                   BindingResult bindingResult,
                                   HttpServletResponse response) {
        Products product = productsRepository.findProduct(productId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "shop/product-details";
        }
        if (userId == null){
            userId = UUID.randomUUID().toString();
            service.addShoppingCartCookieToResponse(response, userId);
            Orders order = new Orders();
            service.insertNewUserOrder(userId,product,form,order);
//            model.addAttribute("isSuccess", true);
        } else if (userId != null){
            Orders order = ordersRepository.findOneWhereStatusShopping(userId);
            if (ordersRepository.findOneWhereStatusShopping(userId) != null){
                ordersRepository.insertInOrdersProducts(order.getId(), product.getId(), form.getQuantity());
            } else {
                Orders newOrder = new Orders();
                service.insertNewUserOrder(userId,product,form,newOrder);
            }
//            model.addAttribute("isSuccess", true);
        } return "redirect:/products/{productId}";
    }

    @PostMapping("/products/add/{productsId}")
    public String addProductToCartProductsViewFrom(@PathVariable(value = "productId", required = false) Long productId,
                                                   @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                                   Model model,
                                                   @Valid AddProductToCartForm form,
                                                   BindingResult bindingResult,
                                                   HttpServletResponse response) {
        if (productId == null) {
            productId = form.getProductId();
        }
        Products product = productsRepository.findProduct(productId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "shop/products";
        }
        if (userId == null){
            userId = UUID.randomUUID().toString();
            service.addShoppingCartCookieToResponse(response, userId);
            Orders order = new Orders();
            service.insertNewUserOrder(userId,product,form,order);
        } else if (userId != null){
            Orders order = ordersRepository.findOneWhereStatusShopping(userId);
            if (ordersRepository.findOneWhereStatusShopping(userId) != null){
                ordersRepository.insertInOrdersProducts(order.getId(), product.getId(), form.getQuantity());
            } else {
                Orders newOrder = new Orders();
                service.insertNewUserOrder(userId,product,form,newOrder);
            }
        } return "redirect:/products";
    }

}
