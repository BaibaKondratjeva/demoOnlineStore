package com.example.demo.onlineshop.front.checkout;

import com.example.demo.onlineshop.Customer;
import com.example.demo.onlineshop.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.demo.cookies.Cookies.USER_ID_COOKIE_NAME;

@Controller
public class CheckOutController {

    private final CheckOutRepository checkOutRepository;

    public CheckOutController(CheckOutRepository checkOutRepository) {
        this.checkOutRepository = checkOutRepository;
    }

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
        model.addAttribute("checkoutForm", new CheckOutForm());
        return "shop/checkout/checkout";
    }

    @PostMapping("/checkout")
    public String submitCheckoutForm (@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
                                     Model model,
                                     CheckOutForm form) {
        checkOutRepository.createCustomer(form);
//        checkOutRepository.createOrder(customer.getId(), order);

        return "shop/checkout/checkout-success";
    }

//
//    @PostMapping("/checkout")
//    public String submitCheckoutForm(@CookieValue(name = USER_ID_COOKIE_NAME, required = false) String userId,
//                                     Model model,
//                                     CheckoutForm form) {
//        System.out.println("received data from browser: " + form);
//        return "shop/checkout/checkout-success";
//    }


}
