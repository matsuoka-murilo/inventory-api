package com.matsuoka.inventoryapi.mapper;

import com.matsuoka.inventoryapi.domain.Category;
import com.matsuoka.inventoryapi.dto.category.CategoryDTO;
import com.matsuoka.inventoryapi.dto.category.CategoryDTOPut;
import com.matsuoka.inventoryapi.dto.category.CatergoryDTOPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract Category toCategory(CategoryDTO categoryDTO);
    public abstract Category toCategory(CatergoryDTOPost catergoryDTOPost);
    public abstract Category toCategory(CategoryDTOPut categoryDTOPut);
}
