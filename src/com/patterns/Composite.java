package com.patterns;

import java.util.Collection;

/**
 * @author Ihar Zharykau
 */
public class Composite {

}

class Category{
    private String name;
    private Collection<Category> childCategories;
    private Collection<Category> parentCategories;
    private Collection<Product> childProduct;

    public Collection<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Collection<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Collection<Category> getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(Collection<Category> parentCategories) {
        this.parentCategories = parentCategories;
    }

    public Collection<Product> getChildProduct() {
        return childProduct;
    }

    public void setChildProduct(Collection<Product> childProduct) {
        this.childProduct = childProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Product{
    private String id;
    private String name;
    private Collection<Category> parentCategories;

    public Collection<Category> getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(Collection<Category> parentCategories) {
        this.parentCategories = parentCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}