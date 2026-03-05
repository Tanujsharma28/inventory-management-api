package com.enterprise.inventory.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.inventory.dto.ProductDto;
import com.enterprise.inventory.mapper.ProductMapper;
import com.enterprise.inventory.model.Product;
import com.enterprise.inventory.service.ProductService;
import com.enterprise.inventory.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

  @PostMapping
public ApiResponse<ProductDto> createProduct(@Valid @RequestBody ProductDto dto) {

    Product product = ProductMapper.mapToEntity(dto);

    Product saved = productService.createProduct(product);

    ProductDto response = ProductMapper.mapToDto(saved);

    return new ApiResponse<>(true, "Product created successfully", response);
}
    // GET ALL
    @GetMapping
    public List<ProductDto> getAllProducts() {

        return productService.getAllProducts()
                .stream()
                .map(ProductMapper::mapToDto)
          
                .collect(Collectors.toList());
    }


    // GET BY ID
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {

        Product product = productService.getProductById(id);

        return ProductMapper.mapToDto(product);
    }
    @GetMapping("/paged")
public List<ProductDto> getProductsWithPagination(
        @RequestParam int page,
        @RequestParam int size) {

    Page<Product> productPage = productService.getAllProducts(page, size);

    return productPage.getContent()
            .stream()
            .map(ProductMapper::mapToDto)
            .toList();
}
@GetMapping("/sorted")
public List<ProductDto> getProductsSorted(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sortBy) {

    Page<Product> productPage =
            productService.getProductsByPage(page, size, sortBy);

    return productPage.getContent()
            .stream()
            .map(ProductMapper::mapToDto)
            .toList();
}


}