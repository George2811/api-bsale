package com.example.api_bsale.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    private Long id;

    private String name;

    public Category() {}
    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Category setName(String name) {
        this.name = name;
        return this;
    }
}
