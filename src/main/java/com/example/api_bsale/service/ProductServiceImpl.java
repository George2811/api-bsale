package com.example.api_bsale.service;

import com.example.api_bsale.domain.model.Product;
import com.example.api_bsale.domain.repository.CategoryRepository;
import com.example.api_bsale.domain.repository.ProductRepository;
import com.example.api_bsale.domain.service.ProductService;
import com.example.api_bsale.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllProductsByCategory(Long category, Pageable pageable) {
        return categoryRepository.findById(category)
                .map(cat -> {
                    Page<Product> products = productRepository.findByCategoryId(category, pageable);
                    return products;
                }).orElseThrow(() -> new ResourceNotFoundException("Categoría", "Id", category));
    }

    @Override
    public Page<Product> getProductsByName(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }
}
