package com.enterprise.inventory.mapper;

import com.enterprise.inventory.dto.ProductDto;
import com.enterprise.inventory.model.Product;

public class ProductMapper {

    // DTO → Entity
    public static Product mapToEntity(ProductDto dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());

        return product;
    }

    // Entity → DTO
    public static ProductDto mapToDto(Product product) {

        ProductDto dto = new ProductDto();

        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setDescription(product.getDescription());

        return dto;
    }
}