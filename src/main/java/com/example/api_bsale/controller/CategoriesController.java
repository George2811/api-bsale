package com.example.api_bsale.controller;

import com.example.api_bsale.domain.model.Category;
import com.example.api_bsale.domain.service.CategoryService;
import com.example.api_bsale.resource.CategoryResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoriesController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Todas las Categorias", description = "Obtener todas las categorias por páginas", tags = {"Categoría"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas las categorias retornadas", content =
            @Content(mediaType = "application/json"))
    })
    @GetMapping("/categories")
    public Page<CategoryResource> getAllCategories(Pageable pageable){
        Page<Category> categoriesPage = categoryService.getAllCategories(pageable);
        List<CategoryResource> resources = categoriesPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    private CategoryResource convertToResource(Category category){
        return mapper.map(category, CategoryResource.class);
    }
}
