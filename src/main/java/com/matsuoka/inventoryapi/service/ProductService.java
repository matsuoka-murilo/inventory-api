package com.matsuoka.inventoryapi.service;

import com.matsuoka.inventoryapi.domain.Category;
import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.ProductDTOPost;
import com.matsuoka.inventoryapi.mapper.ProductMapper;
import com.matsuoka.inventoryapi.repository.CategoryRepository;
import com.matsuoka.inventoryapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(ProductDTOPost productDTO) {
        Long categoryId = productDTO.getCategoryId();
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow( RuntimeException::new);
        Product product = productMapper.toProduct(productDTO);
        product.setCategory(category);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).orElseThrow( RuntimeException::new);
        productRepository.deleteById(id);
    }





}
