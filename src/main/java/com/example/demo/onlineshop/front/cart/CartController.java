package com.example.demo.onlineshop.front.cart;

import com.example.demo.onlineshop.orders.Orders;
import com.example.demo.onlineshop.orders.OrdersProductsTable;
import com.example.demo.onlineshop.orders.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;*/
import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;


@Controller
@RequestMapping
public class CartController {

    @Autowired
    private OrdersRepository ordersRepository;
    private final CartMapper cartMapper;



    public CartController(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @GetMapping("/cart")
    public String cart(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                       Model model) {
       if (cartMapper.orderStatusValidation(userId) != null) {
           List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
           model.addAttribute("cartProducts",cartProducts);
           Long orderId = cartMapper.getOrderIdFromCart(userId);
           model.addAttribute("orderId", orderId);


       } else {
           userId = null;
           List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
           model.addAttribute("cartProducts",cartProducts);
           Long orderId = cartMapper.getOrderIdFromCart(userId);
           model.addAttribute("orderId", orderId);

       }

        return "shop/cart";
    }

    @GetMapping(value ="cart/delete", params = {"orderId","productId"})
    public String deleteProductFromCart(@RequestParam("orderId") Long orderId ,
                                        @RequestParam("productId") Long productId) {

        cartMapper.deleteProductFromCart(orderId, productId);
        return "redirect:/cart";
    }
}
