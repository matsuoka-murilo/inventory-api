package com.matsuoka.inventoryapi.mapper;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.product.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract Product toProduct(ProductDTO productDTO);
}

