package com.example.demo.onlineshop.front.cart.validation;

import com.example.demo.onlineshop.front.products.AddProductToCartForm;
import com.example.demo.onlineshop.products.ProductsRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddProductToCartFormValidator implements
        ConstraintValidator<ValidAddProductToCartForm, AddProductToCartForm>{

    private final ProductsRepository productsRepository;

    public AddProductToCartFormValidator(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void initialize(ValidAddProductToCartForm constraintAnnotation) {

    }

    @Override
    public boolean isValid(AddProductToCartForm form,
                           ConstraintValidatorContext context) {
        if (!productsRepository.isProductAvailableInStock(form.getProductId(), form.getQuantity())) {
            addError("quantity", "Not enough product in stock", context);
            return false;
        }

        return true;
    }

    private void addError(String field, String errorMessage, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage)
                .addPropertyNode(field)
                .addConstraintViolation();
    }
}
