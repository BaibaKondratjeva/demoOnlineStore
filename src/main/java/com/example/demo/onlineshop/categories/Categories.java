package com.example.demo.onlineshop.categories;

import java.util.Objects;

public class Categories {

    private Long id;
    private String name;
    private String imageUri;

    public Categories() {

    }

    public Categories(Long id, String name, String imageUri) {
        this.id = id;
        this.name = name;
        this.imageUri = imageUri;
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
        Categories that = (Categories) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(imageUri, that.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, imageUri);
    }
}
