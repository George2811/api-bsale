package com.example.api_bsale.domain.repository;

import com.example.api_bsale.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
