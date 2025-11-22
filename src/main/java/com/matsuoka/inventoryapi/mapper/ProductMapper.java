package com.matsuoka.inventoryapi.mapper;

import com.matsuoka.inventoryapi.domain.Product;
import com.matsuoka.inventoryapi.dto.ProductDTO;
import com.matsuoka.inventoryapi.dto.ProductDTOPost;
import com.matsuoka.inventoryapi.dto.ProductDTOPut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public abstract ProductDTO toProductDTO(Product product);
    public abstract Product toProduct(ProductDTOPost productDTOPost);
    public abstract Product toProduct(ProductDTOPut productDTOPut);


}

