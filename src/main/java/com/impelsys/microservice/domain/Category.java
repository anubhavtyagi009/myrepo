package com.impelsys.microservice.domain;

public class Category {

    private boolean fiction;
    private boolean nonFiction;

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    public boolean isNonFiction() {
        return nonFiction;
    }

    public void setNonFiction(boolean nonFiction) {
        this.nonFiction = nonFiction;
    }
}
