package com.impelsys.microservice.dto;

public class FluencyAxisDTO {

    private Integer value;

    public FluencyAxisDTO(Integer value) {
        this.value = value;
    }

    public FluencyAxisDTO() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
