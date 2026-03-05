package com.enterprise.inventory.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.enterprise.inventory.exception.BadRequestException;
import com.enterprise.inventory.exception.ResourceNotFoundException;
import com.enterprise.inventory.model.Product;
import com.enterprise.inventory.repository.ProductRepository;
import com.enterprise.inventory.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        
        
        if (product.getPrice() < 0) {
            throw new BadRequestException("Price cannot be negative");
        }

        if (product.getQuantity() < 0) {
            throw new BadRequestException("Quantity cannot be negative");
        }

        if (productRepository.existsByName(product.getName())) {
            throw new BadRequestException("Product with this name already exists");
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product existing = getProductById(id);

        if (product.getPrice() < 0) {
            throw new BadRequestException("Price cannot be negative");
        }

        if (product.getQuantity() < 0) {
            throw new BadRequestException("Quantity cannot be negative");
        }

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setDescription(product.getDescription());

        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return productRepository.findAll(pageable);
    }

    @Override
public Page<Product> getProductsByPage(int page, int size, String sortBy) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

    return productRepository.findAll(pageable);
}
}