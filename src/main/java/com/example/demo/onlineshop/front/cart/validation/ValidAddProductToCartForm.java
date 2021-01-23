package com.example.demo.onlineshop.front.cart.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddProductToCartFormValidator.class)
@Documented
public @interface ValidAddProductToCartForm {

    String message () default "Could not add product to cart";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
