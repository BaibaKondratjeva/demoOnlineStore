package com.example.demo.onlineshop.front.cart;

import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersProductsTable;
import com.example.demo.onlineshop.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;*/
import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;


@Controller
@RequestMapping
public class CartController {

    @Autowired
    private OrdersRepository ordersRepository;
    private final CartMapper cartMapper;



    public CartController(/*OrdersRepository ordersRepository, */CartMapper cartMapper) {
        /*this.ordersRepository = ordersRepository;*/
        this.cartMapper = cartMapper;
    }

    @GetMapping("/cart")
    public String cart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
       if (cartMapper.orderStatusValidation(userId) != null) {
           List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
           Integer grandTotal =cartMapper.grandTotal(userId);

           model.addAttribute("cartProducts",cartProducts);
           model.addAttribute("grandTotal",grandTotal);
       } else {
           userId = null;
           List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
           Integer grandTotal =cartMapper.grandTotal(userId);

           model.addAttribute("cartProducts",cartProducts);
           model.addAttribute("grandTotal",grandTotal);

       }

//        if (cartMapper.orderStatusValidation(userId).equals(ORDER_APPROVED_STATUS_ID)){
//
//        }

        List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
        Integer grandTotal =cartMapper.grandTotal(userId);

        model.addAttribute("cartProducts",cartProducts);
        model.addAttribute("grandTotal",grandTotal);

        return "shop/cart";
    }
}
