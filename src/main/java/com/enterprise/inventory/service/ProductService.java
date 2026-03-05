package com.enterprise.inventory.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.enterprise.inventory.model.Product;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Page<Product> getAllProducts(int page, int size);
    
    Page<Product> getProductsByPage(int page, int size, String sortBy);
}