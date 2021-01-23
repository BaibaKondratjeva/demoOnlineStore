package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.front.cart.CartMapper;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersProductsTable;
import com.example.demo.onlineshop.orders.OrdersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;*/
import java.util.List;

import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class CheckOutController {

    private final CheckOutRepository checkOutRepository;
    private final CheckOutService checkOutService;
    private final OrdersRepository ordersRepository;
    private final CartMapper cartMapper;

    public CheckOutController(CheckOutRepository checkOutRepository, CheckOutService checkOutService, OrdersRepository ordersRepository, CartMapper cartMapper) {
        this.checkOutRepository = checkOutRepository;
        this.checkOutService = checkOutService;
        this.ordersRepository = ordersRepository;
        this.cartMapper = cartMapper;
    }

    //    public CheckOutController(CheckOutRepository checkOutRepository) {
//        this.checkOutRepository = checkOutRepository;
//    }

//    @GetMapping("/checkout")
//    public String checkoutForm (Model model,
//                                @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId) {
//        model.addAttribute("customer", new Customer());
//        model.addAttribute("order", new Orders());
//        return "shop/checkout/checkout";
//    }

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId) {

        List<CartTable> orderedProducts = cartMapper.getCartProducts(userId);

        model.addAttribute("checkoutForm", new CheckOutForm());
        model.addAttribute("orderedProducts", orderedProducts);
        return "shop/checkout/checkout";
    }

    @PostMapping("/checkout")
    public String submitCheckoutForm (@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                     Model model,
                                     CheckOutForm form) {
//        checkOutService.checkout(form, userId);
//        checkOutRepository.createOrder(customer.getId(), order);

        return "shop/checkout/checkout-success";
    }


}
