/*
 * Copyright Benchmark Education Company
 *
 * (C) Copyright BEC - All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant here to is,
 *          and remains, the property of Benchmark.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Benchmark. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Benchmark.
 *
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 * Revision History
 * ========================================================================
 * DATE				: PROGRAMMER  : DESCRIPTION
 * ========================================================================
 * MAY 23 2019		: BEC         : CREATED.
 * ------------------------------------------------------------------------
 *
 * ========================================================================
 */
package com.bec.orrreporting.exception;


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
