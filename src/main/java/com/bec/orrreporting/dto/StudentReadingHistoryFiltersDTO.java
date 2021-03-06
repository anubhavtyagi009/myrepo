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
package com.bec.orrreporting.dto;

public class StudentReadingHistoryFiltersDTO {
    private InternalFilterDTO internalFilter;
    private StudentReadingHistoryExternalFilterDTO externalFilter;

    public InternalFilterDTO getInternalFilter() {
        return internalFilter;
    }

    public void setInternalFilter(InternalFilterDTO internalFilter) {
        this.internalFilter = internalFilter;
    }

    public StudentReadingHistoryExternalFilterDTO getExternalFilter() {
        return externalFilter;
    }

    public void setExternalFilter(StudentReadingHistoryExternalFilterDTO externalFilter) {
        this.externalFilter = externalFilter;
    }
}
