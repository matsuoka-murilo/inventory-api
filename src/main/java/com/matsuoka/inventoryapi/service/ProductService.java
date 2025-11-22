package com.matsuoka.inventoryapi.service;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.ProductDTO;
import com.matsuoka.inventoryapi.mapper.ProductMapper;
import com.matsuoka.inventoryapi.repository.CategoryRepository;
import com.matsuoka.inventoryapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }



}
