package com.example.demo.onlineshop.front.products;

import com.example.demo.onlineshop.front.cart.validation.ValidAddProductToCartForm;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ValidAddProductToCartForm
public class AddProductToCartForm {
    @NotNull
    @Min(value = 1)
    private Integer quantity = 1;
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddProductToCartForm{" +
                "quantity=" + quantity +
                "quantity=" + productId +
                '}';
    }
}
