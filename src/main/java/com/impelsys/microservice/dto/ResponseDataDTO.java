package com.impelsys.microservice.dto;

public class ResponseDataDTO {

    private RplResponseDataDTO responseData;

    public ResponseDataDTO(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }

    public RplResponseDataDTO getResponseData() {
        return responseData;
    }

    public void setResponseData(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }

}
