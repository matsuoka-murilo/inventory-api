package com.matsuoka.inventoryapi.repository;

import com.matsuoka.inventoryapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
