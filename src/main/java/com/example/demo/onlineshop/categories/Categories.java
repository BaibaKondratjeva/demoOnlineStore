package com.example.demo.onlineshop.categories;

import java.util.Objects;

public class Categories {

    private long id;
    private String name;
    private String icon;

    public Categories() {

    }

    public Categories(long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(icon, that.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, icon);
    }
}
