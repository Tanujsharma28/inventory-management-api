package com.enterprise.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
      boolean existsByName(String name);
}