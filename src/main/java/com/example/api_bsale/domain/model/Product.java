package com.example.api_bsale.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    private Long id;

    private String name;
    private String urlImage;
    private float price;
    private int discount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Category category;


    public Product() {}
    public Product(String name, String urlImage, float price, int discount) {
        this.name = name;
        this.urlImage = urlImage;
        this.price = price;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }
    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrlImage() {
        return urlImage;
    }
    public Product setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        return this;
    }

    public float getPrice() {
        return price;
    }
    public Product setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getDiscount() {
        return discount;
    }
    public Product setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public Category getCategory() {
        return category;
    }
    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }
}
