package com.example.api_bsale.resource;

import com.example.api_bsale.domain.model.Category;

public class ProductResource {
    private Long id;
    private String name;
    private String urlImage;
    private float price;
    private int discount;
    private Long category;

    public Long getId() {
        return id;
    }
    public ProductResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public ProductResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }
    public ProductResource setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }

    public float getPrice() {
        return price;
    }
    public ProductResource setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getDiscount() {
        return discount;
    }
    public ProductResource setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public Long getCategoryId() {
        return category;
    }
    public ProductResource setCategoryId(Long category) {
        this.category = category;
        return this;
    }
}
