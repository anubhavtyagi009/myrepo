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

public class StudentReadingLevelDTO {

    private String startingLevel;
    private String readingTarget;

    public String getStartingLevel() {
        return startingLevel;
    }

    public void setStartingLevel(String startingLevel) {
        this.startingLevel = startingLevel;
    }

    public String getReadingTarget() {
        return readingTarget;
    }

    public void setReadingTarget(String readingTarget) {
        this.readingTarget = readingTarget;
    }
}
