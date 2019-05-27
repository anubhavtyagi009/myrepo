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
package com.bec.orrreporting.service.geterroranalysisdata;

import com.bec.orrreporting.dto.ErrorAnalysisFiltersDTO;
import com.bec.orrreporting.service.CommonServiceRequest;

public class GetErrorAnalysisDataRequest implements CommonServiceRequest {

    private ErrorAnalysisFiltersDTO filters;

    public ErrorAnalysisFiltersDTO getFilters() {
        return filters;
    }

    public void setFilters(ErrorAnalysisFiltersDTO filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "GetErrorAnalysisDataRequest{" +
                "filters=" + filters +
                '}';
    }
}
