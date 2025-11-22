package com.matsuoka.inventoryapi.service;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.product.ProductDTO;
import com.matsuoka.inventoryapi.dto.product.ProductDTOPost;
import com.matsuoka.inventoryapi.mapper.ProductMapper;
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

    public Product createProduct(ProductDTOPost productDTO) {
        Product product = productMapper.toProduct(productDTO);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }





}
