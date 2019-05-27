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

import java.util.List;

public class ErrorAnalysisResponseDataDTO {

    private ErrorAnalysisExternalFilterDTO externalFilter;
    private InternalFilterDTO internalFilter;
    private List<DateRangeReadingLevelAxisDTO> dateRangeReadingLevelAxis;
    private ErrorAnalysisDataResultDTO errorAnalysisData;
    private ErrorAnalysisAverageDTO errorAnalysisAverage;
    private ErrorAnalysisDonutDTO errorAnalysisDonutData;
    private MsvAnalysisDonutDTO msvAnalysisDonutData;

    public ErrorAnalysisResponseDataDTO(ErrorAnalysisExternalFilterDTO externalFilter, InternalFilterDTO internalFilter, List<DateRangeReadingLevelAxisDTO> dateRangeReadingLevelAxis, ErrorAnalysisDataResultDTO errorAnalysisData, ErrorAnalysisAverageDTO errorAnalysisAverage, ErrorAnalysisDonutDTO errorAnalysisDonutData, MsvAnalysisDonutDTO msvAnalysisDonutData) {
        this.externalFilter = externalFilter;
        this.internalFilter = internalFilter;
        this.dateRangeReadingLevelAxis = dateRangeReadingLevelAxis;
        this.errorAnalysisData = errorAnalysisData;
        this.errorAnalysisAverage = errorAnalysisAverage;
        this.errorAnalysisDonutData = errorAnalysisDonutData;
        this.msvAnalysisDonutData = msvAnalysisDonutData;
    }

    public ErrorAnalysisResponseDataDTO() {
    }

    public ErrorAnalysisExternalFilterDTO getExternalFilter() {
        return externalFilter;
    }

    public void setExternalFilter(ErrorAnalysisExternalFilterDTO externalFilter) {
        this.externalFilter = externalFilter;
    }

    public InternalFilterDTO getInternalFilter() {
        return internalFilter;
    }

    public void setInternalFilter(InternalFilterDTO internalFilter) {
        this.internalFilter = internalFilter;
    }

    public List<DateRangeReadingLevelAxisDTO> getDateRangeReadingLevelAxis() {
        return dateRangeReadingLevelAxis;
    }

    public void setDateRangeReadingLevelAxis(List<DateRangeReadingLevelAxisDTO> dateRangeReadingLevelAxis) {
        this.dateRangeReadingLevelAxis = dateRangeReadingLevelAxis;
    }

    public ErrorAnalysisDataResultDTO getErrorAnalysisData() {
        return errorAnalysisData;
    }

    public void setErrorAnalysisData(ErrorAnalysisDataResultDTO errorAnalysisData) {
        this.errorAnalysisData = errorAnalysisData;
    }

    public ErrorAnalysisAverageDTO getErrorAnalysisAverage() {
        return errorAnalysisAverage;
    }

    public void setErrorAnalysisAverage(ErrorAnalysisAverageDTO errorAnalysisAverage) {
        this.errorAnalysisAverage = errorAnalysisAverage;
    }

    public ErrorAnalysisDonutDTO getErrorAnalysisDonutData() {
        return errorAnalysisDonutData;
    }

    public void setErrorAnalysisDonutData(ErrorAnalysisDonutDTO errorAnalysisDonutData) {
        this.errorAnalysisDonutData = errorAnalysisDonutData;
    }

    public MsvAnalysisDonutDTO getMsvAnalysisDonutData() {
        return msvAnalysisDonutData;
    }

    public void setMsvAnalysisDonutData(MsvAnalysisDonutDTO msvAnalysisDonutData) {
        this.msvAnalysisDonutData = msvAnalysisDonutData;
    }
}
