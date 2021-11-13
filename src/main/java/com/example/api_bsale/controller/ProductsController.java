package com.example.api_bsale.controller;

import com.example.api_bsale.domain.model.Product;
import com.example.api_bsale.domain.service.ProductService;
import com.example.api_bsale.resource.ProductResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductsController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProductService productService;

    @Operation(summary = "Todas los Productos", description = "Obtener todos los productos por páginas", tags = {"Producto"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos los productos retornados", content =
            @Content(mediaType = "application/json"))
    })
    @GetMapping("/products")
    public Page<ProductResource> getAllProducts(Pageable pageable){
        Page<Product> productsPage = productService.getAllProducts(pageable);
        List<ProductResource> resources = productsPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());

    }

    @Operation(summary = "Todos los productos por su categoría", description = "Buscador de productos según su categoría", tags = {"Producto"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos los productos retornados", content =
            @Content(mediaType = "application/json"))
    })
    @GetMapping("/products/category/{categoryId}")
    public Page<ProductResource> getProductsByCategoryId(@PathVariable Long categoryId, Pageable pageable){
        Page<Product> productsPage = productService.getAllProductsByCategory(categoryId, pageable);
        List<ProductResource> resources = productsPage.getContent().
                stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Producto por su nombre", description = "Buscador de producto según su nombre", tags = {"Producto"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos retornado", content =
            @Content(mediaType = "application/json"))
    })
    @GetMapping("/products/name/{name}")
    public ProductResource getProductByName(@PathVariable String name){
        return convertToResource(productService.getProductByName(name));
    }

    private ProductResource convertToResource(Product product){
        return mapper.map(product, ProductResource.class);
    }
}
