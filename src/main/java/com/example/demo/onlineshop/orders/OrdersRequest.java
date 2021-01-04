package com.example.demo.onlineshop.orders;

import com.example.demo.onlineshop.categories.Categories;

import java.math.BigDecimal;
import java.util.List;

public class OrdersRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String imageUri;
    private List<Categories> categoryIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<Categories> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Categories> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
