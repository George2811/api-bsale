package com.example.api_bsale.domain.service;

import com.example.api_bsale.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Page<Product> getAllProductsByCategory(Long category, Pageable pageable);
    Product getProductByName(String name);
}
