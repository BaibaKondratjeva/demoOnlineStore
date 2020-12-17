package com.example.demo.onlineshop.products;

import java.math.BigDecimal;
import java.util.Objects;

public class Products {

    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String imageUri;

    public Products () {

    }

    public Products(long id, String name, String description, BigDecimal price, int quantity, String imageUri) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUri = imageUri;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return id == products.id &&
                quantity == products.quantity &&
                Objects.equals(name, products.name) &&
                Objects.equals(description, products.description) &&
                Objects.equals(price, products.price) &&
                Objects.equals(imageUri, products.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, quantity, imageUri);
    }
}
