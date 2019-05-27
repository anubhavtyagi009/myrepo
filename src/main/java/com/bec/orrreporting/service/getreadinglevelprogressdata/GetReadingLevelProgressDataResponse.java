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
package com.bec.orrreporting.service.getreadinglevelprogressdata;

import com.bec.orrreporting.dto.RplResponseDataDTO;
import com.bec.orrreporting.service.CommonServiceResponse;

public class GetReadingLevelProgressDataResponse extends CommonServiceResponse {

    private RplResponseDataDTO responseData;

    public GetReadingLevelProgressDataResponse(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }

    public RplResponseDataDTO getResponseData() {
        return responseData;
    }

    public void setResponseData(RplResponseDataDTO responseData) {
        this.responseData = responseData;
    }
}
