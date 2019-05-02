package com.impelsys.microservice.dto;

public class CategoryDTO {

    private boolean fiction;
    private boolean nonfiction;

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    public boolean isNonfiction() {
        return nonfiction;
    }

    public void setNonfiction(boolean nonfiction) {
        this.nonfiction = nonfiction;
    }
}
