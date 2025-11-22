package com.matsuoka.inventoryapi.service;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.product.ProductDTO;
import com.matsuoka.inventoryapi.mapper.ProductMapper;
import com.matsuoka.inventoryapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product toProduct(ProductDTO productDTO) {
        return productMapper.toProduct(productDTO);
    }




}
