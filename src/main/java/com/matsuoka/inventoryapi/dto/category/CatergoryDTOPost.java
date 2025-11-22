package com.matsuoka.inventoryapi.dto.category;

import jakarta.validation.constraints.NotNull;

public class CatergoryDTOPost {
    @NotNull
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CatergoryDTOPost() {
    }
}
