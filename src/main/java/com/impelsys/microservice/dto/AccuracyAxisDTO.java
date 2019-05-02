package com.impelsys.microservice.dto;

public class AccuracyAxisDTO {

    private Integer value;

    public AccuracyAxisDTO(Integer value) {
        this.value = value;
    }

    public AccuracyAxisDTO() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
