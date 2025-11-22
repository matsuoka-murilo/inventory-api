package com.matsuoka.inventoryapi.mapper;

import com.matsuoka.inventoryapi.domain.Category;
import com.matsuoka.inventoryapi.dto.category.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract Category toCategory(CategoryDTO categoryDTO);
}
