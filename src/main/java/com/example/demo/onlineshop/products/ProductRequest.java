package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ProductRequest {

    protected Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String imageUri;
    private Set<Long> categoryIds;
    private List<Categories> categories;

    ProductRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryIds=" + categoryIds +
                '}';
    }
}
