package com.example.demo.onlineshop.front;

import com.example.demo.onlineshop.categories.Categories;
import com.example.demo.onlineshop.categories.CategoriesRepository;
import com.example.demo.onlineshop.front.cart.CartMapper;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.orders.OrdersRepository;
import com.example.demo.onlineshop.products.ProductRequest;
import com.example.demo.onlineshop.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
@RequestMapping
public class HomePageController {
    private final ProductsRepository repository;
    private final CategoriesRepository categoriesRepository;

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    public HomePageController(CategoriesRepository categoriesRepository, ProductsRepository repository /*OrdersRepository ordersRepository*/) {
        this.categoriesRepository = categoriesRepository;
        this.repository = repository;
    }

    @GetMapping(path = {"/"})
    public String home(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
        List<Categories> allCategories = categoriesRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        List<ProductRequest> allProducts = repository.findAll();
        model.addAttribute("allProducts", allProducts);
        List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
        model.addAttribute("cartProducts",cartProducts);
        return "shop/index";
    }

    @GetMapping("/about")
    public String about(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                        Model model) {
        List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
        model.addAttribute("cartProducts",cartProducts);
        return "shop/about";
    }
}








