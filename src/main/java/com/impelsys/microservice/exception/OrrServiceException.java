/*
 * @Copyright © 2017. eRx Solutions Pvt Ltd
 * @author john@erxindia.in
 * @project eRx
 * @version eRx v2.0
 * @module billing-microservice
 * @createdon 04-Dec-2017
 */
package com.impelsys.microservice.exception;

/**
 * Created by mkpatil on 06/11/17.
 */
public class OrrServiceException extends RuntimeException {
    protected static final String DEFAULT_ERROR_CODE = "SERVICE_ERROR";
    protected static final String DEFAULT_ERROR_REASON = "defaultReason";
    private static final long serialVersionUID = 8583684468837771559L;
    protected final String errorCode;
    protected final String errorReason;


    public OrrServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
        this.errorReason = DEFAULT_ERROR_REASON;
    }

    public OrrServiceException() {
        super();
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorReason = DEFAULT_ERROR_REASON;
    }

    public OrrServiceException(String message) {
        super(message);
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorReason = DEFAULT_ERROR_REASON;
    }

    public OrrServiceException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorReason = DEFAULT_ERROR_REASON;
    }

    public OrrServiceException(Throwable cause) {
        super(cause);
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorReason = DEFAULT_ERROR_REASON;
    }

    public OrrServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = DEFAULT_ERROR_CODE;
        this.errorReason = DEFAULT_ERROR_REASON;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorReason() {
        return errorReason;
    }

}
