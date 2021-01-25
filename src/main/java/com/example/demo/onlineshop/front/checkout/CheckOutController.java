package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.front.cart.CartMapper;
import com.example.demo.onlineshop.front.cart.CartTable;
import com.example.demo.onlineshop.http.HttpRequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;*/
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static com.example.demo.onlineshop.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class CheckOutController {

    private final CheckOutService checkOutService;
    private final CartMapper cartMapper;

    public CheckOutController(CheckOutService checkOutService, CartMapper cartMapper) {
        this.checkOutService = checkOutService;
        this.cartMapper = cartMapper;
    }

    @GetMapping("/checkout")
    public String checkout(Model model,
                           @CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId) {

        List<CartTable> orderedProducts = cartMapper.getCartProducts(userId);
        model.addAttribute("checkoutForm", new CheckOutForm());
        model.addAttribute("orderedProducts", orderedProducts);
        List<CartTable> cartProducts = cartMapper.getCartProducts(userId);
        model.addAttribute("cartProducts",cartProducts);
        return "shop/checkout/checkout";
    }

    @PostMapping("/checkout")
    public String submitCheckoutForm (@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                      Model model,
                                      @Valid CheckOutForm form,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<CartTable> orderedProducts = cartMapper.getCartProducts(userId);
            model.addAttribute("checkoutForm", form);
            model.addAttribute("orderedProducts", orderedProducts);
            return "shop/checkout/checkout";
        }

        checkOutService.checkout(form, userId);
        return "shop/checkout/checkout-success";
    }

}
