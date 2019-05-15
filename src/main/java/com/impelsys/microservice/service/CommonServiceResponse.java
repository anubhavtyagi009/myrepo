package com.impelsys.microservice.service;

/**
 * Created by mkpatil on 13/10/17.
 */
public abstract class CommonServiceResponse {

    public  boolean SUCCESSFUL = true;
    Integer errorCode;
    String errorMessage;
    private String message;

    public CommonServiceResponse() {

    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
