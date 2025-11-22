package com.matsuoka.inventoryapi.dto;

import com.matsuoka.inventoryapi.domain.Product;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
