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

import com.bec.orrreporting.dto.FiltersDTO;
import com.bec.orrreporting.service.CommonServiceRequest;

public class GetReadingLevelProgressDataRequest implements CommonServiceRequest {

    private FiltersDTO filters;

    public FiltersDTO getFilters() {
        return filters;
    }

    public void setFilters(FiltersDTO filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "GetReadingLevelProgressDataRequest{" +
                "filters=" + filters +
                '}';
    }
}
