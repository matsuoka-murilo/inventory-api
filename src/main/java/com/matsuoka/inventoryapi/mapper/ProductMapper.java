package com.matsuoka.inventoryapi.mapper;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.product.ProductDTO;
import com.matsuoka.inventoryapi.dto.product.ProductDTOPost;
import com.matsuoka.inventoryapi.dto.product.ProductDTOPut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract Product toProduct(ProductDTO productDTO);
    public abstract Product toProduct(ProductDTOPost productDTOPost);
    public abstract Product toProduct(ProductDTOPut productDTOPut);


}

