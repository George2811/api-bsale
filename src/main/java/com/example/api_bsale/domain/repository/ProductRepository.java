package com.example.api_bsale.domain.repository;

import com.example.api_bsale.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(Long category, Pageable pageable);
    Optional<Product> findByName(String name);
}
