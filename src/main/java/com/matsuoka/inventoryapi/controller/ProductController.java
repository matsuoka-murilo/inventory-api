package com.matsuoka.inventoryapi.controller;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.product.ProductDTOPost;
import com.matsuoka.inventoryapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTOPost productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        productService.getAllProducts();
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

}
