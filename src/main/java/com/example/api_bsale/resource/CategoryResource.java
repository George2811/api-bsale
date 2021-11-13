package com.example.api_bsale.resource;

public class CategoryResource {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }
    public CategoryResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public CategoryResource setName(String name) {
        this.name = name;
        return this;
    }
}
