package com.matsuoka.inventoryapi.repository;

import com.matsuoka.inventoryapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
