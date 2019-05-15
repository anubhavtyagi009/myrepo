package com.impelsys.microservice.domain;

public class ResponseData {

    private RplResponsedataDto responseData;

    public ResponseData(RplResponsedataDto responseData) {
        this.responseData = responseData;
    }

    public RplResponsedataDto getResponseData() {
        return responseData;
    }

    public void setResponseData(RplResponsedataDto responseData) {
        this.responseData = responseData;
    }

}
